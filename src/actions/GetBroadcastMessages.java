package actions;

import beans.message;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class GetBroadcastMessages extends ActionSupport implements status{
        private int STATUS;
        private ArrayList<message> messages;
        private int id;
    private message [] broadcast_messages;

    public message[] getBroadcast_messages() {
        return broadcast_messages;
    }

    public void setBroadcast_messages(message[] broadcast_messages) {
        this.broadcast_messages = broadcast_messages;
    }


    public ArrayList<message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<message> messages) {
        this.messages = messages;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(id);
        messages=new ArrayList<message>();
       ServletContext sctx= ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        String querySql = "select message_id from unreadboardcastmessages where  to_user_id='" + id
                + "'";
        ResultSet rs,rs1;
        rs = con.createStatement().executeQuery(querySql);

        while (rs.next()){
            int message_id=rs.getInt(1);
            System.out.println(message_id);
            querySql = "select title,content,create_time from messages where  id='" + message_id
                    + "'";
            rs1=con.createStatement().executeQuery(querySql);
            while (rs1.next()){
                System.out.println(rs1.getString(1));
                messages.add(new message(rs1.getString(1),rs1.getString(2),rs1.getString(3)));

            }
        }
        Iterator iterator=messages.iterator();
        while (iterator.hasNext()){
            System.out.println(((message)iterator.next()).getTitle());
        }
        //Integer[] newText = (Integer[])v.toArray(new Integer[0]);
       broadcast_messages= (message [] )messages.toArray(new message[0]);
        for (int i=0;i<broadcast_messages.length;i++)
            System.out.println(broadcast_messages[i].getTitle()+" "+broadcast_messages[i].getTitle());
        STATUS=SUCCESSFUL;
        return SUCCESS;
    }


}