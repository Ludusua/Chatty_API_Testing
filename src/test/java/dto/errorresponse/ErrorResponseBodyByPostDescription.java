package dto.errorresponse;

import java.util.List;

public class ErrorResponseBodyByPostDescription {
    List<String> description;

    public ErrorResponseBodyByPostDescription() {
    }

    public ErrorResponseBodyByPostDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
