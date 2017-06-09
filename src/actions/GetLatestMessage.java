package actions;

import beans.LatestMessage;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetLatestMessage extends ActionSupport implements status {
    private String localID;

    private ArrayList<LatestMessage> messages;
    private LatestMessage[] lm;

    public LatestMessage[] getLm() {
        return lm;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }





    @Override
    public String execute() throws Exception {
        System.out.println("android"+localID);
        messages=new ArrayList<LatestMessage>();
        ServletContext sctx= ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        String querySql = "SELECT msui,mct,content,user_name\n" +
                "FROM messages,user_info,\n" +
                "  (SELECT send_user_id AS msui, MAX(messages.create_time) AS mct\n" +
                "FROM messages WHERE to_user_id="+localID+" OR to_user_id=0\n" +
                "GROUP BY send_user_id) AS tb\n" +
                "WHERE msui=user_id AND msui=send_user_id and messages.create_time=mct; ";
        ResultSet rs=con.createStatement().executeQuery(querySql);
        while (rs.next()){
            messages.add(new LatestMessage(rs.getString(1),rs.getString(4),rs.getString(3),rs.getString(2)));
            System.out.println(rs.getString(1));
        }
        lm=(LatestMessage[]) messages.toArray(new LatestMessage[0]);
        System.out.println(lm[0].getLastMessage());
        return SUCCESS;

    }
}