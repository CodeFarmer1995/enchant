package actions;

import beans.MusicItem;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchMusic extends ActionSupport {
    private String artist_name;
    private String music_name;
    private int sc;
    private int sn;
    ArrayList<MusicItem> musicList;



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

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    @Override
    public String execute() throws Exception {
        int limit = sc;
        int offset = (sn - 1) * sc;
        musicList=new ArrayList<MusicItem>();

        if(artist_name.equals(""))
            artist_name="%";
        if(music_name.equals(""))
            music_name="%";

        ServletContext sctx = ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        ResultSet rs;

       String querySQL = "SELECT music_id,music_name,artist_name,music_file FROM music_info WHERE  artist_name like '"+artist_name+"' AND  music_name LIKE '"+music_name+"' ";
        System.out.println(querySQL);
       rs=con.createStatement().executeQuery(querySQL);
       while (rs.next()){
           MusicItem music=new MusicItem(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
           musicList.add(music);
       }
       return SUCCESS;
    }
}
