package loginProject;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args)throws SQLException {
        UserInterface userInterface = new UserInterface();
        UserDao userDao = new UserDao();
        while (true) {
            int menuNum = userInterface.printMenu();
            if (menuNum == 1) {
                userInterface.printSaveUser();
            } else if (menuNum == 2) {
                User user = userInterface.printLogin();
                if (user != null) {
                    while (true) {
                        int menuNum_2 = userInterface.printMenu_2();
                        if (menuNum_2 == 1) {
                            userInterface.printUpdate(user.getId());
                        } else if (menuNum_2 == 2) {
                            userDao.deleteUser(user.getId());
                        } else if (menuNum_2 == 0) {
                            break;
                        }
                    }
                }
            } else if (menuNum == 3) {
                while (true) {
                    int menuNum_3 = userInterface.printMenu_3();
                    if (menuNum_3 == 1) {
                        userDao.getUsers();
                    } else if (menuNum_3 == 2) {
                        String id = userInterface.printSearchId();
                        userInterface.printUpdate(id);
                    }else if (menuNum_3 == 3) {
                        String id = userInterface.printSearchId();
                        userDao.deleteUser(id);
                    } else if (menuNum_3 == 0) {
                        break;
                    }
                }
            } else if (menuNum == 0) {
                break;
            } else {
                System.out.println("올바른 메뉴를 선택하세요");
            }
        }
    }
}
