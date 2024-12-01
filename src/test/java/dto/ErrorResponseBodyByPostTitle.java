package dto;

import java.util.List;

public class ErrorResponseBodyByPostTitle {
    List<String> title;

    public ErrorResponseBodyByPostTitle(List<String> title) {
        this.title = title;
    }

    public ErrorResponseBodyByPostTitle() {
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
