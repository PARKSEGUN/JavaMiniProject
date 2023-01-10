package miniproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//메모리상에 User정보를 관리하는 클래스
public class UserServiceInMemory implements UserService{
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        for (User someUser : users) {
            if(someUser.getEmail().equals(user.getEmail())){
                someUser.setName(user.getName());
                someUser.setBirthYear(user.getBirthYear());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        for (User someUser : users) {
            if(someUser.getEmail().equals(user.getEmail())){
                users.remove(someUser);
                return true;
            }
        }
        return false;
    }

    //필드 users 정보를 그대로 리턴할거냐
    // users정보를 복사한후 리턴할 것이냐
    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }
}
