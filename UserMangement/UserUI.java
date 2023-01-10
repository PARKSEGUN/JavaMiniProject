package miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class UserUI {

    private BufferedReader br;

    public UserUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu() {
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록보기");
        System.out.println("3. 회원수정");
        System.out.println("4. 회원삭제");
        System.out.println("5. 종료");

        int menuId=-1;
        try {

            String line=br.readLine();  //readLine은 String 으로 리턴
            menuId=Integer.parseInt(line);  //문자열을 정수로 변환
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuId;
    }

    //1번 메뉴
    public User regMenu() {
        try {
            System.out.println("email을 입력하세요");
            String email = br.readLine();
            System.out.println("이름을 입력하세요");
            String name = br.readLine();
            System.out.println("생년을 입력하세요");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear);

            User user = new User(email, name, birthYear);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //2번 메뉴
    public void printUserList(Iterator<User> iter) {
        System.out.println("email         이름          생년");
        System.out.println("==============================");
        while(iter.hasNext()) {
            User user = iter.next();
            System.out.print(user.getEmail());
            System.out.print("       ");
            System.out.print(user.getName());
            System.out.print("       ");
            System.out.print(user.getBirthYear());
            System.out.print("       ");
            System.out.println();
        }
    }

    //3번 메뉴 (수정)
    public void modifyUser(Iterator<User> iter) {
        System.out.println("수정할 email 을 입력하세요");
        try {
            String email = br.readLine();
            while(iter.hasNext()) {
                User user = iter.next();
                if (user.getEmail().equals(email)) {
                    System.out.println("이름을 입력하세요");
                    String name = br.readLine();
                    user.setName(name);
                    System.out.println("생년을 입력하세요");
                    String strBirthYear = br.readLine();
                    int birthYear = Integer.parseInt(strBirthYear);
                    user.setBirthYear(birthYear);
                    System.out.println("수정이 완료되었습니다");
                    return;
                }
            }
            System.out.println("회원정보에 알맞은 email이 존재하지않습니다");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUser(Iterator<User> iter) {

        System.out.println("삭제할 email 을 입력하세요");
        try {
            String email = br.readLine();
            while(iter.hasNext()) {
                User user = iter.next();
                if (user.getEmail().equals(email)) {
                    iter.remove();
                    System.out.println("삭제가 완료되었습니다");
                    return;
                }
            }
            System.out.println("회원정보에 알맞은 email이 존재하지않습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
