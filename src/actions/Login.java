package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends ActionSupport implements status {
    private String email;
    private String password;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private int STATUS;


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

    public int getSTATUS() {
        return STATUS;
    }


    @Override
    public String execute() throws Exception {
        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");

        if (email == null) {
            Cookie[] cks = ServletActionContext.getRequest().getCookies();
            if (cks != null) {
                for (Cookie ck : cks) {
                    if ("email".equals(ck.getName())) {
                        email = ck.getValue();
                    }
                    if ("password".equals(ck.getName())) {
                        password = ck.getValue();
                    }
                }
            }
        }
        System.out.println(email + " " + password + " " + token);

        String querySql = "select ext_info from user_info where  ext_info='" + token
                + "'";
        ResultSet rs;
        rs = con.createStatement().executeQuery(querySql);

        if (token != null) {
            if (rs.next())
                STATUS = SUCCESSFUL;
            else
                STATUS = TOKEN_NOT_EXITED;
        } else {
            querySql = "select user_password from user_info where  user_email='" + getEmail()
                    + "'";
            rs = con.createStatement().executeQuery(querySql);
            if (!rs.next()) {
                STATUS = EMAIL_NOT_EXISTED;
                ServletActionContext.getResponse().getWriter().print("<script>alert('login error!');window.location.href='/enchant/enchantAdmin/login.html';</script>");
                String uagent=ServletActionContext.getRequest().getHeader("User-Agent");
                if(uagent.matches(".*AppleWebKit.*") || uagent.matches(".*Mozilla.*") || uagent.matches(".*Chrome.*") ){                    return null;
                }

                // return ERROR;
            } else {


                if (!rs.getString(1).equals(getPassword())) {
                    STATUS = PASSWORD_WRONG;
                    //return ERROR;
                    ServletActionContext.getResponse().getWriter().print("<script>alert('login error!');window.location.href='/enchant/enchantAdmin/login.html';</script>");

                    //return "<script>alert('login error!');window.location.href='/enchantAdmin/login.html';</script>";
                  //return  "WebError";
                    String uagent=ServletActionContext.getRequest().getHeader("User-Agent");
                    System.out.println(uagent);
                    if(uagent.matches(".*AppleWebKit.*") || uagent.matches(".*Mozilla.*") || uagent.matches(".*Chrome.*") ){
                        return null;
                    }

                } else
                    STATUS = SUCCESSFUL;
            }
        }
        ServletActionContext.getResponse().addCookie(new Cookie("email",email));
        ServletActionContext.getResponse().addCookie(new Cookie("password",password));
        querySql = "select user_type,user_id from user_info where  user_email='" + getEmail()
                + "'";
        rs = con.createStatement().executeQuery(querySql);
        if (rs.next()) {
            ServletActionContext.getRequest().getSession().setAttribute("user_id", rs.getInt(2));

            if (rs.getInt(1) == 0) {
                ServletActionContext.getRequest().getSession().setAttribute("admin", "yes");
                return "WebAdmin";
            }
            ServletActionContext.getRequest().getSession().setAttribute("admin", "no");
        }
        return "AndroidUser";
    }

}

