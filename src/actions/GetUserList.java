package actions;

import beans.UserItem;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetUserList extends ActionSupport {

    private int sc;
    private int sn;
    private ArrayList<UserItem> userList;
    private UserItem[] users;

    public int getSc() {
        return sc;
    }

    public int getSn() {
        return sn;
    }

    public ArrayList<UserItem> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserItem> userList) {
        this.userList = userList;
    }

    public UserItem[] getUsers() {
        return users;
    }

    public void setUsers(UserItem[] users) {
        this.users = users;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    @Override
    public String execute() throws Exception {
        int limit = sc;
        int offset = (sn - 1) * sc;
        System.out.println(sc + " " + sn);
        userList = new ArrayList<UserItem>();

        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        ResultSet rs, rs1;
//        String querySql="SELECT count(music_id) FROM music_info";
//        rs=con.createStatement().executeQuery(querySql);
//        if(rs.next()){
//            offset=rs.getInt(1)/limit;
//        }

        String querySql = "SELECT user_id,user_name,user_email,user_sex,user_type,user_avatar FROM user_info limit "+limit+" offset "+offset+" ";
        System.out.println(querySql);
        rs = con.createStatement().executeQuery(querySql);
        while (rs.next()) {

            UserItem useritem = new UserItem(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6));
            System.out.println(useritem.getAvatar());
            userList.add(useritem);
        }
        users=(UserItem[])userList.toArray(new UserItem[0]);
        System.out.println(users.length+" "+users[0].getType());
        return SUCCESS;
    }
}