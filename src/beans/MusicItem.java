package beans;

/**
 * Created by Jack on 2017-06-08.
 */
public class MusicItem {
    private int id;
    private String music_name;
    private String artist_name;
    private String music_file;

    public MusicItem(int id, String music_name, String artist_name, String music_file) {
        this.id = id;
        this.music_name = music_name;
        this.artist_name = artist_name;
        this.music_file = music_file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getMusic_file() {
        return music_file;
    }

    public void setMusic_file(String music_file) {
        this.music_file = music_file;
    }
}
