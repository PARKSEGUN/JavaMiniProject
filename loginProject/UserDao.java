package loginProject;

import java.lang.reflect.Member;
import java.sql.*;

public class UserDao {

    private String url = "jdbc:mysql://localhost:3306/practice";
    private String userName = "root";
    private String userPassword = "0505";

    public void saveUser(User user) throws SQLException {
        String id = user.getId();
        String password = user.getPassword();
        String name = user.getName();
        String email = user.getEmail();

        Connection connection = DriverManager.getConnection(url, userName, userPassword);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "   insert into login (id,password,name,email) values (?,?,?,?)" +
                "");

        preparedStatement.setString(1,id);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,name);
        preparedStatement.setString(4, email);
        preparedStatement.executeUpdate();
        System.out.println("회원가입 완료");
        System.out.println(user.toString());
        preparedStatement.close();
        connection.close();

    }

    public User getUser(String id, String password) throws SQLException{
        User user=null;

        Connection connection = DriverManager.getConnection(url, userName, userPassword);
        PreparedStatement preparedStatement=connection.prepareStatement("" +
                "select * from login where id=? and password =? " +
                "");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String bringId=resultSet.getString("id");
            String bringPassword=resultSet.getString("password");
            String bringName=resultSet.getString("name");
            String bringEmail=resultSet.getString("email");
            user = new User(bringId, bringPassword, bringName, bringEmail);
            System.out.println("로그인 성공");
            System.out.println(user.toString());
        }
        else{
            System.out.println("올바르지 않은 ID 또는 Password ");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void updateUser(String id,User newUser) throws SQLException{
        Connection connection = DriverManager.getConnection(url, userName, userPassword);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "update login set id=?,password=?,name=?,email=? where id=?");
        preparedStatement.setString(1,newUser.getId());
        preparedStatement.setString(2,newUser.getPassword());
        preparedStatement.setString(3,newUser.getName());
        preparedStatement.setString(4,newUser.getEmail());
        preparedStatement.setString(5,id);
        preparedStatement.executeUpdate();
        System.out.println("수정되었습니다");
        System.out.println(newUser.toString());
        preparedStatement.close();
        connection.close();
    }

    public void deleteUser(String id)throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, userPassword);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "delete from login where id=?");
        preparedStatement.setString(1,id);
        preparedStatement.executeUpdate();
        System.out.println("삭제되었습니다");

        preparedStatement.close();
        connection.close();
    }

    public void getUsers()throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, userPassword);
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select * from login");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            User user = new User(id, password, name, email);
            System.out.println(user.toString());
        }
    }

}
