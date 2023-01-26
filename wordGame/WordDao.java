package wordGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDao {
    private String url = "jdbc:mysql://localhost:3306/practice";
    private String userName = "root";
    private String userPw = "0505";

    public void saveWord(Word word) throws SQLException {

            String question = word.getQuestion();
            String answer = word.getAnswer();
            int score = word.getPoint();

            Connection connection = DriverManager.getConnection(url, userName, userPw);
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "insert into word values(?,?,?)");
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            preparedStatement.setInt(3, score);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

    }

    public void getWords()throws SQLException {
        Connection connection = DriverManager.getConnection(url,userName,userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from word");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            String question= resultSet.getString("question");
            String answer = resultSet.getString("answer");
            int score = resultSet.getInt("score");

            Word word = new Word(question, answer, score);
            System.out.println(word.toString());
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

    public void deleteWord(String question)throws Exception {
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "delete from word where question=? ");
        preparedStatement.setString(1, question);
        preparedStatement.executeUpdate();
        System.out.println("삭제되었습니다");

        preparedStatement.close();
        connection.close();
    }

    public Word getRandomWord(int searchScore)throws Exception {
        Word word=null;
        Connection connection = DriverManager.getConnection(url,userName,userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from word where score=? order by rand() Limit 1 ");
        preparedStatement.setInt(1, searchScore);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            String question= resultSet.getString("question");
            String answer = resultSet.getString("answer");
            int score = resultSet.getInt("score");

            word = new Word(question, answer, score);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return word;
    }

}
