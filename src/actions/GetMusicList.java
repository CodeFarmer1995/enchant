package actions;

import beans.Music;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetMusicList extends ActionSupport implements status {
        private ArrayList<Music> musicList;
        private Music[] music;
        private int sc;  //limit
        private int  sn;  //offset

    public Music[] getMusic() {
        return music;
    }

    public void setMusic(Music[] music) {
        this.music = music;
    }

    public ArrayList<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(ArrayList<Music> musicList) {
        this.musicList = musicList;
    }

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

    @Override
    public String execute() throws Exception {
        int limit=sc;
        int offset=1;
        System.out.println(sc+" "+sn);
        musicList=new ArrayList<Music>();
        ServletContext sctx= ServletActionContext.getServletContext();
        Connection con = (Connection) sctx.getAttribute("DBCon");
        String querySql = "select * from music_info limit " + limit
                + " OFFSET  "+offset+" ";
        ResultSet rs,rs1;
        rs = con.createStatement().executeQuery(querySql);
        while (rs.next()){
//            System.out.println(rs.getInt(1));
//                    rs.getString(2);
//                    rs.getInt(3);
//                    rs.getString(4);
//                    rs.getString(5);
//                    rs.getString(6);
//                    rs.getString(7);
//            System.out.println(   rs.getInt(8));
//                    rs.getString(9);
//                    rs.getString(10);
//                    rs.getInt(11);
//                    rs.getString(12);
//                    rs.getInt(13) ;
//                    rs.getInt(14);
            Music musiciteam=new Music(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getInt(11),
                    rs.getString(12),
                    rs.getInt(13) ,
                    rs.getInt(14));
            System.out.println(musiciteam.getAlbum()+" "+musiciteam.getUpdate_time());
            musicList.add(musiciteam);
        }

        music=(Music[])musicList.toArray(new Music[0]);

        return SUCCESS;
    }
}