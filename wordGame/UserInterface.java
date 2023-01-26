package wordGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface {

    UserDao userDao = new UserDao();
    WordDao wordDao = new WordDao();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int printMenu() throws Exception {
        try {
            int menuNum = -1;
            System.out.println("단어 게임에 오신것을 환영합니다!");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("3. ID 찾기");
            System.out.println("4. PW 찾기");
            System.out.println("5. 관리자 모드");
            System.out.println("0. 종료");
            System.out.print("입력 : ");
            menuNum = Integer.parseInt(br.readLine());
            return menuNum;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return 0;
    }

    public int printLoginMenu() throws Exception {
        try{
        int menuNum = -1;
        System.out.println("1. 게임 시작");
        System.out.println("2. 내 정보 보기");
        System.out.println("3. 랭킹 보기");
        System.out.println("4. 정보 수정");
        System.out.println("5. 회원 탈퇴");
        System.out.println("0. 이전");
        System.out.print("입력 : ");
        menuNum = Integer.parseInt(br.readLine());
        return menuNum;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return 0;
    }

    public int printAdminMenu() throws Exception {
        try{
        int menuNum = -1;
        System.out.println("1. 회원 정보 전체 보기");
        System.out.println("2. 회원 정보 수정");
        System.out.println("3. 회원 정보 삭제");
        System.out.println("4. 단어 관리");
        System.out.println("5. 회원 찾기");
        System.out.println("0. 이전");
        System.out.print("입력 : ");
        menuNum = Integer.parseInt(br.readLine());
        return menuNum;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return 0;
    }

    public int wordManageMenu() throws Exception {
        try{
        int menuNum = -1;
        System.out.println("1. 단어 전체 보기");
        System.out.println("2. 단어 추가");
        System.out.println("3. 단어 삭제");
        System.out.println("0. 이전");
        System.out.print("입력 : ");
        menuNum = Integer.parseInt(br.readLine());
        return menuNum;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return 0;
    }

    public void printRegist() throws Exception {
        try{
        System.out.print("ID : ");
        String id = br.readLine();
        System.out.print("PW : ");
        String pw = br.readLine();
        System.out.print("NAME : ");
        String name = br.readLine();
        System.out.print("EMAIL : ");
        String email = br.readLine();

        User user = new User(id, pw, name, email);
        userDao.saveUser(user);
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
    }

    public User printLogin() throws Exception {
        try{
        System.out.print("ID : ");
        String id = br.readLine();
        System.out.print("PW : ");
        String pw = br.readLine();
        User user = userDao.getUser(id);
        if (user != null && user.getPw().equals(pw)) {
            System.out.println("로그인 완료");
        } else System.out.println("올바른 ID 또는 PW가 아닙니다");
        return user;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return null;
    }

    public void printSearchId() throws Exception {
        try{
        System.out.print("NAME : ");
        String name = br.readLine();
        System.out.print("EMAIL : ");
        String email = br.readLine();
        User user = userDao.findId(name, email);
        if (user != null) {
            System.out.println("ID : " + user.getId());
        }
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
    }

    public void printSearchPw() throws Exception {
        try{
        System.out.print("ID : ");
        String id = br.readLine();
        System.out.print("NAME : ");
        String name = br.readLine();
        System.out.print("EMAIL : ");
        String email = br.readLine();
        User user = userDao.findPw(id, name, email);
        if (user != null) {
            System.out.println("PW : " + user.getPw());
        }
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
    }

    public String printAdmin() throws Exception {
        try{
        System.out.println("관리자 비밀번호 입력 : ");
        String adminPw = br.readLine();
        return adminPw;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return null;
    }

    public User printUpdateUser(String id) throws Exception {
        try{
        System.out.print("ID : ");
        String newId = br.readLine();
        System.out.print("PW : ");
        String newPw = br.readLine();
        System.out.print("NAME : ");
        String newName = br.readLine();
        System.out.print("EMAIL : ");
        String newEmail = br.readLine();


        User newUser = new User(newId, newPw, newName, newEmail);
        userDao.updateUser(id, newUser);
            System.out.println("수정되었습니다");
            System.out.println(newUser.toString());
        return newUser;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return null;
    }
    public User printUpdateUserAdmin(String id) throws Exception {
        try{
        System.out.print("ID : ");
        String newId = br.readLine();
        System.out.print("PW : ");
        String newPw = br.readLine();
        System.out.print("NAME : ");
        String newName = br.readLine();
        System.out.print("EMAIL : ");
        String newEmail = br.readLine();
        System.out.print("SCORE : ");
        int newScore = Integer.parseInt(br.readLine());

        User newUser = new User(newId, newPw, newName, newEmail,newScore);
        userDao.updateUser(id, newUser);
            System.out.println("수정되었습니다");
            System.out.println(newUser.toString());
        return newUser;
        }catch(NumberFormatException e){
            System.out.println("올바른 입력을 해주세요");
        }
        return null;
    }

    public void addWord() throws Exception {
        try {
        System.out.println("추가하실단어를 입력하세요");
        System.out.print("단어 : ");
        String question = br.readLine();
        System.out.print("답 : ");
        String answer = br.readLine();
        System.out.print("난의도 : ");
        int score = Integer.parseInt(br.readLine());
        Word word = new Word(question, answer, score);
        wordDao.saveWord(word);
        }catch(Exception e){
            System.out.println("올바른 입력을 해주세요");
        }
    }

    public void gameStart(User user) throws Exception {
        try {
            System.out.println("게임을 시작합니다!");
            System.out.println("난의도를 설정해주세요 1 ~ 3 입력");
            System.out.print("원하시는 난의도 : ");
            int score = Integer.parseInt(br.readLine());
            Word word = wordDao.getRandomWord(score);
            System.out.println("단어 : " + word.getQuestion());
            System.out.print("뜻 : ");
            String answer = br.readLine();
            if (answer.equals(word.getAnswer())) {
                System.out.println("정답입니다!");
                user.setScore(user.getScore() + score);
            } else System.out.println("틀렸습니다!");
            userDao.updateUser(user.getId(), user);
        } catch (Exception e) {
            System.out.println("올바른 입력을 해주세요");
        }
    }
}
