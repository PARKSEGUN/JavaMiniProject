package miniproject;

import java.util.Iterator;
import java.util.List;

public interface UserService  {
    //회원 정보를 등록
    public void addUser(User user);

    //회원정보 수정
    public boolean updateUser(User user);

    //회원 정보 삭제
    public boolean deleteUser(User user);

    //회원정보 반환
    public Iterator<User> getUsers();

}
