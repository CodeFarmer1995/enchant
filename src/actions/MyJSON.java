package actions;

import beans.User;
import beans.bean;
import beans.message;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyJSON extends ActionSupport {
    private String name;
    private String age;
    private HashMap<String,String> family;
    public String getName() {
        return name;
    }
    private String[] info;
    private User user;
    private HashSet<message> messages;
    private Set<bean> beans;

    public Set<bean> getBeans() {
        return beans;
    }

    public void setBeans(Set<bean> beans) {
        this.beans = beans;
    }

    public HashSet<message> getMessages() {
        return messages;
    }

    public void setMessages(HashSet<message> messages) {
        this.messages = messages;
    }

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
//        Iterator<bean> ib=beans.iterator();
//        while ((ib.hasNext())){
//            System.out.println(ib.next().getC());
//        }
        messages=new HashSet<message>();
        messages.add(new message("1","2","3"));
        messages.add(new message("2","2","3"));
        return SUCCESS;
    }
}