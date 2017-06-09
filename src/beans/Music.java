package beans;

/**
 * Created by Jack on 2017-06-05.
 */
public class Music {
    private int music_id;
    private String music_name;
    private int user_id;
    private String artist_name;
    private String album;
    private String cover_file;
    private String quality;
    private int duration;
    private String music_file;
    private String lyric_file;
    private  int music_type;
    private  String ext_info;
    private  int update_time;
    private  int create_time;

    public Music(int music_id, String music_name, int user_id, String artist_name, String album, String cover_file, String quality, int duration, String music_file, String lyric_file, int music_type, String ext_info, int update_time, int create_time) {
        this.music_id = music_id;
        this.music_name = music_name;
        this.user_id = user_id;
        this.artist_name = artist_name;
        this.album = album;
        this.cover_file = cover_file;
        this.quality = quality;
        this.duration = duration;
        this.music_file = music_file;
        this.lyric_file = lyric_file;
        this.music_type = music_type;
        this.ext_info = ext_info;
        this.update_time = update_time;
        this.create_time = create_time;
    }

    public int getMusic_type() {
        return music_type;
    }

    public void setMusic_type(int music_type) {
        this.music_type = music_type;
    }

    public String getMusic_file() {
        return music_file;
    }

    public void setMusic_file(String music_file) {
        this.music_file = music_file;
    }

    public String getLyric_file() {
        return lyric_file;
    }

    public void setLyric_file(String lyric_file) {
        this.lyric_file = lyric_file;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCover_file() {
        return cover_file;
    }

    public void setCover_file(String cover_file) {
        this.cover_file = cover_file;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getExt_info() {
        return ext_info;
    }

    public void setExt_info(String ext_info) {
        this.ext_info = ext_info;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }


}
