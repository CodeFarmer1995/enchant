package beans;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Jack on 2017-05-28.
 */
public class User implements Serializable {
    private String user_email;
    private String user_password;
    private String user_name;
    private String user_sex;    //0男1女
    private File user_avatar;
    private String user_avatarFileName;
    private String description;
    private String ext_info;
    private String user_type;   //0管理员1用户

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public File getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(File user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getUser_avatarFileName() {
        return user_avatarFileName;
    }

    public void setUser_avatarFileName(String user_avatarFileName) {
        this.user_avatarFileName = user_avatarFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExt_info() {
        return ext_info;
    }

    public void setExt_info(String ext_info) {
        this.ext_info = ext_info;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }



}
