package BankManagement;

import java.util.List;

public interface BankService {
    //회원 추가
    public void addUser(User user);

    //회원 조회
    public User getUser(String id);

    //회원 수정
    public boolean updateUser(User user);

    //회원 삭제
    public boolean deleteUser(String id);

    //예금
    public boolean saveMoney(String id,int money);

    //출금
    public boolean bringMoney(String id,int money);


    //전체 데이터 조회
    public List<User> getAllUser();
}
