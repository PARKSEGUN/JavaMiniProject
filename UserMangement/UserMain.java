package miniproject;

import java.util.List;

public class UserMain {

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/Users/박세건/data/users.dat");
        UserService userService = new UserServiceInMemory(userDao.getUsers());

        while(true){
            int menuId = userUI.menu();
            if(menuId==5){
                System.out.println("종료합니다");
                userDao.saveUser(userService.getUsers());

                break;
            }else if (menuId==1){
                User user = userUI.regMenu();
                userService.addUser(user);
                System.out.println("등록되었습니다");

            }else if(menuId==2){
                userUI.printUserList(userService.getUsers());

            }else if(menuId==3){
                userUI.modifyUser(userService.getUsers());
            }
            else if(menuId==4){
                userUI.deleteUser(userService.getUsers());
            }
        }
    }
}
