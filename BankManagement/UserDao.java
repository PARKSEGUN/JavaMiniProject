package BankManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String fileName;

    public UserDao(String fileName) {
        this.fileName = fileName;
    }

    public void saveUser(List<User> users){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(users);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        File file = new File(fileName);
        if(file.exists()==false){
            return new ArrayList<>();
        }
        List<User> list=null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            list = (List<User>) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
