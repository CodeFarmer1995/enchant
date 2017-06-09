package beans;

/**
 * Created by Jack on 2017-06-07.
 */
public class UserItem {
    private int id;
    private String name;
    private String email;
    private int sex;
    private int type;
    private String avatar;

    public UserItem(int id, String name, String email, int sex, int type, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.type = type;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
