package BankManagement;

import UserMangement.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserUI {
    private BufferedReader br;

    public UserUI(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    //메뉴창
    public int menu() {
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 조회");
        System.out.println("3. 회원 수정");
        System.out.println("4. 회원 삭제");
        System.out.println("5. 예금");
        System.out.println("6. 출금");
        System.out.println("7. 회원 전체 조회");
        System.out.println("8. 종료");
        System.out.print("원하시는 서비스를 입력해주세요 입력 : ");
        int menuNum=-1;
        try {
            String input = br.readLine();
            menuNum = Integer.parseInt(input);
        }catch (Exception e){
            e.printStackTrace();
        }
        return menuNum;
    }

    //회원등록
    public User addUser(){
        try {
            System.out.print("ID 입력 : ");
            String id = br.readLine();
            System.out.print("이름 입력 : ");
            String name = br.readLine();
            System.out.print("금액 입력 : ");
            String input = br.readLine();
            int money = Integer.parseInt(input);
            User user = new User(id, name, money);
            return user;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //회원 조회
    public String getUser(){
        System.out.print("찾으시는 회원의 ID 입력 : ");
        try{
             String id = br.readLine();
             return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //회원 수정
    public User updateUser(){

        try{
            System.out.print("찾으시는 회원의 ID 입력 : ");
            String id = br.readLine();

            System.out.print("이름 입력 : ");
            String name = br.readLine();
            System.out.print("금액 입력 : ");
            String input = br.readLine();
            int money = Integer.parseInt(input);
            User user = new User(id, name, money);
            return user;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
    //회원 삭제
    public String deleteUser(){
       return  getUser();
    }
    //예금
    public int saveMoney(){
        try{
            System.out.print("금액 입력 : ");
            String input = br.readLine();
            int money = Integer.parseInt(input);
            return money;

        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    //출금
    public int bringMoney(){
        try{
            System.out.print("금액 입력 : ");
            String input = br.readLine();
            int money = Integer.parseInt(input);
            return money;

        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
