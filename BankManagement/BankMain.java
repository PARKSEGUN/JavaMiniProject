package BankManagement;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BankMain {

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/Users/박세건/data/users1.dat");
        BankService bankService = new BankMemory(userDao.getUsers());


        while(true){
            int menuNum = userUI.menu();
            if(menuNum==1){
                bankService.addUser(userUI.addUser());
            }else if(menuNum==2){
                String id=userUI.getUser();
                User user=bankService.getUser(id);
                System.out.print("ID = " + user.getId());
                System.out.print(" | 이름 = " + user.getName());
                System.out.println(" | 잔고 = " + user.getMoney());
            }else if(menuNum==3){
                User user = userUI.updateUser();
                bankService.updateUser(user);
                System.out.println("수정 완료");
            }else if(menuNum==4){
                String id= userUI.getUser();
                bankService.deleteUser(id);
                System.out.println("삭제 완료");
            }else if(menuNum==5){
                String id= userUI.getUser();
                int money = userUI.saveMoney();
                bankService.saveMoney(id, money);
                System.out.println("예금 완료");
            }else if(menuNum==6){
                String id= userUI.getUser();
                int money = userUI.bringMoney();
                bankService.bringMoney(id, money);
                System.out.println("출금 완료");
            }else if(menuNum==7){
                List<User> users = bankService.getAllUser();
                for (User user : users) {
                    System.out.print(" | ID = " + user.getId());
                    System.out.print(" | 이름 = " + user.getName());
                    System.out.println(" | 잔고 = " + user.getMoney());
                }
            }else if(menuNum==8){
                System.out.println("프로그램 종료");
                userDao.saveUser(bankService.getAllUser());
                break;
            }
        }
    }
}
