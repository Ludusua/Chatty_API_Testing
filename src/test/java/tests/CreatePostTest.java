package tests;

import dto.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.BaseTest.postRequest;
import static tests.UtilUrl.CREATE_POST;


public class CreatePostTest {
    @Test
    public void successPostCreating() {
        PostRequest postBody = PostRegistry.getNormalNonDraftPost();
        PostResponse response = postRequest(CREATE_POST, 201, postBody)
                .body().jsonPath().getObject("", PostResponse.class);
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getTitle().isEmpty());
        assertFalse(response.getBody().isEmpty());
        assertFalse(response.getDescription().isEmpty());

    }
}
