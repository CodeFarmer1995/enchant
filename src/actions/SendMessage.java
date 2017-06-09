package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;

public class SendMessage extends ActionSupport {

    private int send_user_id;
    private int to_user_id;
    private String title;
    private String content;
    private long create_time;
    private int STATUS;

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    @Override
    public String execute() throws Exception {
        if(title.equals(""))
            title="user message";
        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        ResultSet rs;
        create_time=System.currentTimeMillis() / 1000;
        String updateSQL="INSERT INTO messages(send_user_id, to_user_id, message_type, content, title, create_time) VALUE ("+send_user_id+","+to_user_id+",2,'"+content+"','"+title+"',"+create_time+")";

        con.createStatement().executeUpdate(updateSQL);
        updateSQL="INSERT INTO unreadmessages(send_user_id, to_user_id, message_type, content, title, create_time) VALUE ("+send_user_id+","+to_user_id+",2,'"+content+"','"+title+"',"+create_time+")";
        con.createStatement().executeUpdate(updateSQL);

        STATUS=1000;
        return SUCCESS;

    }
}