package dto.response;

public class PostResponseBody {
    private String id;
    private String title;
    private String description;
    private String body;
    private String imageUrl;
    private String publishDate;
    private String updatedAt;
    private boolean draft;
    private String userId;

    public PostResponseBody() {
    }

    public PostResponseBody(String id, String title, String description, String body, String imageUrl, String publishDate, String updatedAt, boolean draft, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.publishDate = publishDate;
        this.updatedAt = updatedAt;
        this.draft = draft;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
