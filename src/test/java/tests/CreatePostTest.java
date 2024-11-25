package tests;

import dto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static tests.BaseTest.postRequest;
import static tests.BaseTest.postRequestWithoutToken;
import static tests.UtilUrl.CREATE_POST;
import static tests.UtilUrl.USER_LOGIN;

public class CreatePostTest {
    @Test
    public void successPostCreating() {
        PostRequest post = PostRegistry.getNormalNonDraftPost();
        PostResponse response = postRequest(CREATE_POST, 200, post)
                .body().jsonPath().getObject("", PostResponse.class);

    }
}
