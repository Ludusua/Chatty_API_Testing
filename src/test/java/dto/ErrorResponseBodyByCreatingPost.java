package dto;

import java.util.List;

public class ErrorResponseBodyByCreatingPost {
    List<String> title;

    public ErrorResponseBodyByCreatingPost(List<String> title) {
        this.title = title;
    }

    public ErrorResponseBodyByCreatingPost() {
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
