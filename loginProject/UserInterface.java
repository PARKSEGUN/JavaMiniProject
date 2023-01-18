package loginProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class UserInterface {
    private UserDao userDao = new UserDao();


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int printMenu() {
        int menuNum = -1;
        System.out.println("원하시는 메뉴를 입력해주세요 : ");
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.println("3. 관리자모드");
        System.out.println("0 서비스 종료");

        try {
            menuNum = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuNum;
    }

    public int printMenu_2() {
        int menuNum = -1;
        System.out.println("원하시는 메뉴를 입력해주세요 : ");
        System.out.println("1. 정보 수정");
        System.out.println("2. 정보 삭제");
        System.out.println("0 서비스 종료");

        try {
            menuNum = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuNum;
    }

    public int printMenu_3() {
        int menuNum = -1;
        System.out.println("원하시는 메뉴를 입력해주세요 : ");
        System.out.println("1. 회원 정보 모두 보기");
        System.out.println("2. 정보 수정");
        System.out.println("3. 정보 삭제");
        System.out.println("0 서비스 종료");

        try {
            menuNum = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuNum;
    }
    public void printSaveUser() {
        try {
            System.out.print("Id : ");
            String id = br.readLine();
            System.out.print("Password : ");
            String password = br.readLine();
            System.out.print("Name : ");
            String name = br.readLine();
            System.out.print("Email : ");
            String email = br.readLine();
            User user = new User(id, password, name, email);
            userDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User printLogin() {
        try {
            System.out.print("Id : ");
            String id = br.readLine();
            System.out.print("Password : ");
            String password = br.readLine();
            User user = userDao.getUser(id, password);
            if (user != null) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printUpdate(String updateId){
        try {
            System.out.print("Id : ");
            String id = br.readLine();
            System.out.print("Password : ");
            String password = br.readLine();
            System.out.print("Name : ");
            String name = br.readLine();
            System.out.print("Email : ");
            String email = br.readLine();
            User newUser = new User(id, password, name, email);
            userDao.updateUser(updateId,newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String printSearchId(){
        try {
            System.out.print("Id : ");
            String id = br.readLine();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

