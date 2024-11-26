package dto;

public class PostRequestBody {
    private String title;
    private String description;
    private String body;
    private String imageUrl;
    private String publishDate;
    private boolean draft;

    public PostRequestBody(String title, String description, String body, String imageUrl, String publishDate, boolean draft) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.publishDate = publishDate;
        this.draft = draft;
    }

    public PostRequestBody() {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }
}
