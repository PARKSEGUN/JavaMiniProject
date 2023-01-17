package databasePractice;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class UserMain {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/practice";
        String userName = "root";
        String password = "0505";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 모든 회원 조회");
            System.out.println("0. 종료");

            System.out.println("원하시는 메뉴를 선택하세요 입력 : ");
            int menuNum = -1;
            try {
                menuNum = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //회원 추가
            if (menuNum == 1) {
                try {
                    System.out.print("ID : ");
                    String id = br.readLine();
                    System.out.print("이름 : ");
                    String name = br.readLine();
                    System.out.print("전화번호 : ");
                    String phone = br.readLine();
                    System.out.print("나이 : ");
                    int age = Integer.parseInt(br.readLine());
                    statement.executeUpdate("insert into practice values ('" + id + "','" + name + "','" + phone + "'," + age + ")");
                    System.out.println("등록되었습니다");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //회원 조회
            else if (menuNum == 2) {
                System.out.print("찾으시는 회원의 ID 를 입력하세요 : ");
                try {
                    String inputId = br.readLine();
                    resultSet = statement.executeQuery("select * from practice where id= "+ inputId  );
                    resultSet.next();
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    int age = resultSet.getInt("age");
                    User user = new User(id, name, phone, age);
                    System.out.println(user.toString());

                } catch (Exception e) {
                    System.out.println("찾으시는 ID가 없습니다");
                }
            }
            //회원 조회
            else if(menuNum==3){
               // UPDATE Person SET description='TITLE1 is ...' WHERE id=1;
                System.out.print("찾으시는 회원의 ID 를 입력하세요 : ");
                try {
                    String inputId = br.readLine();
                    System.out.print("이름 : ");
                    String name = br.readLine();
                    System.out.print("전화번호 : ");
                    String phone = br.readLine();
                    System.out.print("나이 : ");
                    int age = Integer.parseInt(br.readLine());
                    statement.executeUpdate(
                            "update practice set " +
                            "name='"+name+"'," +
                            "phone='"+phone+"'," +
                            "age='"+age+"' " +
                            "where id = "+inputId
                    );
                    System.out.println("수정되었습니다");

                } catch (Exception e) {
                    System.out.println("찾으시는 ID가 없습니다");
                }
            }
            //회원 삭제
            else if(menuNum==4){
                System.out.print("찾으시는 회원의 ID 를 입력하세요 : ");
                try {
                    String inputId = br.readLine();
                    statement.executeUpdate("delete from practice where id="+inputId);
                    System.out.println("삭제되었습니다");

                } catch (Exception e) {
                    System.out.println("찾으시는 ID가 없습니다");
                }
            }
            else if(menuNum==5){
                resultSet=statement.executeQuery("select * from practice");
                while(resultSet.next()){
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    int age = resultSet.getInt("age");
                    User user = new User(id, name, phone, age);
                    System.out.println(user.toString());
                }
            }
            else if(menuNum==0){
                break;
            }
        }
    }
}
