package actions;

import beans.FeedBack;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetFeedBack extends ActionSupport {
    private  ArrayList<FeedBack> fbList;
    private  int sc;
    private int sn;

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public ArrayList<FeedBack> getFbList() {
        return fbList;
    }

    public void setFbList(ArrayList<FeedBack> fbList) {
        this.fbList = fbList;
    }

    @Override
    public String execute() throws Exception {
        int limit = sc;
        int offset = (sn - 1) * sc;
        fbList=new ArrayList<FeedBack>();

        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        ResultSet rs;

        String querySQL= "select send_user_id,title,content from messages where message_type="+1+" limit "+limit+" offset "+offset+" ";
        rs=con.createStatement().executeQuery(querySQL);
        while (rs.next()){
            FeedBack fbItem=new FeedBack(rs.getInt(1),rs.getString(2),rs.getString(3));
            fbList.add(fbItem);
            System.out.println(fbItem.getContent());
        }

        return SUCCESS;


    }
}