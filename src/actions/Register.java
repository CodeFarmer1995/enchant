package actions;

import beans.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends ActionSupport implements status {
    private User user;
    private String code;
    private String email;
    private String password;
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int STATUS;

    public int getSTATUS() {
        return STATUS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String register() throws Exception {
        System.out.println(token);
        ServletContext sctx = ServletActionContext.getServletContext();
        HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con = (Connection) sctx.getAttribute("DBCon");

        System.out.println(ServletActionContext.getRequest().getContentType());
        System.out.println(code + " " + email + " " + name);
        String insertSql = "insert into  user_info(user_email,user_password,user_name,user_sex,description,ext_info,user_type,create_time,update_time,user_avatar) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String querySql = "select email from users where email='" + email
                + "'";
        PreparedStatement pstat;

        querySql = "select code from email_code where email='" + email
                + "'";
        String CODE = null;
        ResultSet rs = con.createStatement().executeQuery(querySql);

        if (rs.next())
            CODE = rs.getString(1);
        if (code.equals(CODE)) {
            querySql = "select user_email from user_info where user_email='" + email
                    + "'";
            rs = con.createStatement().executeQuery(querySql);
            if (rs.next()) {
                STATUS = EMAIL_EXISTED;
                return "RegisterResult";
            }
            rs = con.createStatement().executeQuery(querySql);
            pstat = con.prepareStatement(insertSql);
            pstat.setString(1, email);
            pstat.setString(2, password);
            pstat.setString(3, name);
            pstat.setInt(4, 0);
            pstat.setString(5, "");
            if (token == null)
                pstat.setString(6, "");
            else
                pstat.setString(6, token);
            pstat.setString(7, "1");
            pstat.setLong(8, System.currentTimeMillis() / 1000);
            pstat.setLong(9, System.currentTimeMillis() / 1000);
            pstat.setString(10, "");
            System.out.println(pstat);
            // pstat.setString(6, user.getUavatar());
            pstat.execute();
            STATUS = REGISTER_SUCESS;
            pstat.close();
        } else {
            STATUS = CODE_WRONG;
        }

        return "RegisterResult";
    }
}