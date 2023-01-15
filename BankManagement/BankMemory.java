package BankManagement;

import java.util.List;
import java.util.Objects;

public class BankMemory implements BankService {

    List<User> users;

    public BankMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User getUser(String id) {
        for (User user : users) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updateUser(User findUser) {
        for (User user : users) {
            if (user.getId().equals(findUser.getId())) {
                user.setName(findUser.getName());
                user.setMoney(findUser.getMoney());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        User findUser=getUser(id);
        for (User user : users) {
            if (user.getId().equals(findUser.getId())) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveMoney(String id,int money) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setMoney(user.getMoney() + money);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean bringMoney(String id,int money) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setMoney(user.getMoney() - money);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }
}
