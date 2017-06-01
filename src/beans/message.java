package beans;

/**
 * Created by Jack on 2017-05-31.
 */
public class message {
    private String title;
    private String content;
    private String create_time;

    public message(String title, String content, String create_time) {
        this.title = title;
        this.content = content;
        this.create_time = create_time;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
