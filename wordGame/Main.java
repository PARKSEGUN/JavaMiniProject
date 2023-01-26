package wordGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String adminNum = "0505";
        UserInterface userInterface = new UserInterface();
        UserDao userDao = new UserDao();
        WordDao wordDao = new WordDao();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int menuNum = userInterface.printMenu();
            if (menuNum == 1) {
                userInterface.printRegist();
            } else if (menuNum == 2) {
                User user = userInterface.printLogin();
                if (user != null) {
                    while (true) {
                        int loginMenuNum = userInterface.printLoginMenu();
                        if (loginMenuNum == 1) {
                            userInterface.gameStart(user);
                        } else if (loginMenuNum == 2) {
                            System.out.println(user.toString());
                        } else if (loginMenuNum == 3) {
                            List<User> users=userDao.getUsers();
                            for (User lookUser : users) {
                                System.out.println(
                                        "ID : "+lookUser.getId()+
                                                " | NAME : "+lookUser.getName()+
                                                " | SCORE : "+lookUser.getScore()
                                );
                            }
                        } else if (loginMenuNum == 4) {
                            user = userInterface.printUpdateUser(user.getId());
                        } else if (loginMenuNum == 5) {
                            userDao.deleteUser(user.getId());
                            break;
                        } else if (loginMenuNum == 0) {
                            break;
                        }
                    }
                }
            } else if (menuNum == 3) {
                userInterface.printSearchId();
            } else if (menuNum == 4) {
                userInterface.printSearchPw();
            } else if (menuNum == 5) {
                String input = userInterface.printAdmin();
                if (input.equals(adminNum)) {
                    while (true) {
                        int adminMenuNum = userInterface.printAdminMenu();
                        if (adminMenuNum == 1) {
                            List<User> users = userDao.getUsers();
                            for (User user : users) {
                                System.out.println(user.toString());
                            }
                        } else if (adminMenuNum == 2) {
                            System.out.print("수정할 회원의 ID : ");
                            String id = br.readLine();
                            System.out.println(userDao.getUser(id).toString());
                            userInterface.printUpdateUserAdmin(id);
                        } else if (adminMenuNum == 3) {
                            System.out.print("삭제할 회원의 ID : ");
                            String id = br.readLine();
                            userDao.deleteUser(id);
                        } else if (adminMenuNum == 4) {
                            while (true) {
                                int wordInput = userInterface.wordManageMenu();
                                if (wordInput == 1) {
                                    wordDao.getWords();
                                } else if (wordInput == 2) {
                                    userInterface.addWord();
                                } else if (wordInput == 3) {
                                    System.out.print("삭제할 단어 : ");
                                    String question = br.readLine();
                                    wordDao.deleteWord(question);
                                } else if (wordInput == 0)
                                    break;
                            }
                        } else if (adminMenuNum == 5) {
                            System.out.print("찾으실 회원의 ID : ");
                            String id = br.readLine();
                            User user = userDao.getUser(id);
                            if(user!=null) {
                                System.out.println(user.toString());
                            }
                            else System.out.println("찾으시는 ID는 없는 ID 입니다");
                        } else if (adminMenuNum == 0) {
                            break;
                        }
                    }

                } else
                    System.out.println("올바른 PW가 아닙니다");
            } else if (menuNum == 0) {
                break;
            }
        }
        System.out.println("게임 종료");
    }

}
