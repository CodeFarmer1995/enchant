package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReleaseNotice extends ActionSupport implements status {
    private String noticeTitle;
    private String noticeContent;
    private int STATUS;

    public int getSTATUS() {
        return STATUS;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(noticeContent+" "+noticeTitle);
        System.out.println((String)ServletActionContext.getRequest().getSession().getAttribute("admin"));
        Connection con = (Connection) ServletActionContext.getServletContext().getAttribute("DBCon");
        if( (String)ServletActionContext.getRequest().getSession().getAttribute("admin") == null || ((String)ServletActionContext.getRequest().getSession().getAttribute("admin")).equals("no")){
            STATUS=NO_PRIVILEGES;
            return ERROR;
        }

        String insertSql = "insert into messages(send_user_id,to_user_id,message_type,title,content,create_time) value (?,?,?,?,?,?)";
        PreparedStatement  pstat = con.prepareStatement(insertSql);
       int send_user_id= (int)ServletActionContext.getRequest().getSession().getAttribute("user_id");
        pstat.setInt(1,send_user_id);
        pstat.setInt(2,0);
        pstat.setInt(3,0);
        pstat.setString(4,noticeTitle);
        pstat.setString(5,noticeContent);
        long time=System.currentTimeMillis()/1000;
        pstat.setLong(6,time );
        System.out.println(pstat.toString());
        pstat.execute();
        String uagent=ServletActionContext.getRequest().getHeader("User-Agent");
        System.out.println(uagent);

        String querySql = "select id from messages where send_user_id ='"+send_user_id+"'and create_time = '"+time+"' ";
        ResultSet rs=con.createStatement().executeQuery(querySql);
        rs.next();
        int message_id=rs.getInt(1);
        querySql = "select user_id from user_info ";
        rs = con.createStatement().executeQuery(querySql);
        int to_user_id;
        while (rs.next()){
            to_user_id=rs.getInt(1);
            con.createStatement().execute("INSERT INTO unreadboardcastmessages (to_user_id,message_id,`read`) VALUES ("+to_user_id+","+message_id+",0)");
        }
        if(uagent.matches(".*AppleWebKit.*") || uagent.matches(".*Mozilla.*") || uagent.matches(".*Chrome.*") ){
            ServletActionContext.getResponse().getWriter().print("<script>alert('Upload Success!');window.location.href='/enchant/enchantAdmin/index.html';</script>");

            return null;
        }
        return "result";
    }
}