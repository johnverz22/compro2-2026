package to.dev.blog.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;
    private String title;
    private String description;
    private String url;
    @SerializedName("readable_publish_date")
    private String publishedDate;

    private User user;
    
    public Post(int id, String title, String description, String url, String publishedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishedDate = publishedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return String.format("%s (by %s) - %s", title, user.getName(), url);
    }
}
