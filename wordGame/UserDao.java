package wordGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String url = "jdbc:mysql://localhost:3306/practice";
    private String userName = "root";
    private String userPw = "0505";

    public void saveUser(User user) throws SQLException {
        String id = user.getId();
        String pw = user.getPw();
        String name = user.getName();
        String email = user.getEmail();
        int score = user.getScore();

        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "insert into gameuser values(?,?,?,?,?)");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, pw);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, email);
        preparedStatement.setInt(5, score);
        preparedStatement.executeUpdate();
        System.out.println("회원가입 완료");

        preparedStatement.close();
        connection.close();
    }

    public User getUser(String searchId) throws SQLException {
        User user = null;
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from gameuser where id=? ");
        preparedStatement.setString(1, searchId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String id = resultSet.getString("id");
            String pw = resultSet.getString("pw");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int score = resultSet.getInt("score");

            user = new User(id, pw, name, email, score);


        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public User findId(String name, String email) throws Exception {
        User user = null;
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from gameuser where name=? and email=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String bringId = resultSet.getString("id");
            String bringPw = resultSet.getString("pw");
            String bringName = resultSet.getString("name");
            String bringEmail = resultSet.getString("email");
            int bringPoint = resultSet.getInt("score");

            user = new User(bringId, bringPw, bringName, bringEmail, bringPoint);

        } else System.out.println("일치하는 ID가 없습니다");
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public User findPw(String Id, String name, String email) throws Exception {
        User user = null;
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from gameuser where Id=? and name=? and email=?");
        preparedStatement.setString(1, Id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String bringId = resultSet.getString("id");
            String bringPw = resultSet.getString("pw");
            String bringName = resultSet.getString("name");
            String bringEmail = resultSet.getString("email");
            int bringPoint = resultSet.getInt("score");

            user = new User(bringId, bringPw, bringName, bringEmail, bringPoint);

        } else System.out.println("일치하는 정보가 없습니다!");
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void updateUser(String id, User newUser)  {
        try {
            Connection connection = DriverManager.getConnection(url, userName, userPw);
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "update gameuser set id=?,pw=?,name=?,email=?,score=? where id=?");
            preparedStatement.setString(1, newUser.getId());
            preparedStatement.setString(2, newUser.getPw());
            preparedStatement.setString(3, newUser.getName());
            preparedStatement.setString(4, newUser.getEmail());
            preparedStatement.setInt(5, newUser.getScore());
            preparedStatement.setString(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        }catch(Exception e){
            System.out.println("이미 있는 ID 입니다");
        }


    }

    public void deleteUser(String id) throws Exception {
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "delete from gameuser where id=? ");
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
        System.out.println("삭제되었습니다");

        preparedStatement.close();
        connection.close();
    }

    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DriverManager.getConnection(url, userName, userPw);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from gameuser order by score desc ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String pw = resultSet.getString("pw");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int score = resultSet.getInt("score");

            User user = new User(id, pw, name, email, score);
            users.add(user);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return users;
    }
}
