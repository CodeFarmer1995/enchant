package actions;

import beans.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;

public class MyJSON extends ActionSupport {
    private String name;
    private String age;
    private HashMap<String,String> family;
    public String getName() {
        return name;
    }
    private String[] info;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, String> getFamily() {
        return family;
    }

    public void setFamily(HashMap<String, String> family) {
        this.family = family;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String json(){
//        name="jack";
//        age="22";
        System.out.println(age+" "+name);

        return SUCCESS;
    }
}