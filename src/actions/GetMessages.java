package actions;

import beans.message;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetMessages extends ActionSupport {
    private int send_user_id;
    private int to_user_id;
    private ArrayList<message> messages;

    public int getSend_user_id() {
        return send_user_id;
    }

    public void setSend_user_id(int send_user_id) {
        this.send_user_id = send_user_id;
    }

    public int getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(int to_user_id) {
        this.to_user_id = to_user_id;
    }

    public ArrayList<message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<message> messages) {
        this.messages = messages;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(send_user_id+" "+to_user_id);
        messages=new ArrayList<message>();
        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        String querySQL;

        ResultSet rs,rs1;
        int message_id=0;

        if(send_user_id == 1){
            querySQL="SELECT message_id FROM unreadboardcastmessages WHERE  to_user_id="+to_user_id+"  ORDER BY message_id DESC ";
            System.out.println(querySQL);
            rs1=con.createStatement().executeQuery(querySQL);
            while(rs1.next()){
                message_id=rs1.getInt(1);
                rs=con.createStatement().executeQuery("SELECT title,content,create_time FROM messages WHERE id = "+message_id+" ");
                messages.add(new message(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            //System.out.println(message_id);
           // rs=con.createStatement().executeQuery("SELECT title,content,create_time FROM messages WHERE id = "+message_id+" ");
            //messages.add(new message(rs.getString(1),rs.getString(2),rs.getString(3)));
        }
            querySQL = "SELECT title,content,create_time FROM messages WHERE send_user_id=" + send_user_id + " AND to_user_id=" + to_user_id + "";
            System.out.println(querySQL);
            rs = con.createStatement().executeQuery(querySQL);

        while (rs.next()){
            messages.add(new message(rs.getString(1),rs.getString(2),rs.getString(3)));
            System.out.println(rs.getString(1));
        }

        //con.createStatement().executeUpdate("DELETE FROM unreadmessages WHERE send_user_id="+send_user_id+" AND  to_user_id="+to_user_id+"");

        return SUCCESS;
    }
}