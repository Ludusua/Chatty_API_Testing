package tests;

import dto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.BaseTest.postRequest;
import static tests.UtilUrl.CREATE_POST;


public class CreatePostTest {
    @Test
    public void successNonDraftPostCreating() {
        PostRequestBody postBody = PostRegistry.getNormalNonDraftPost();
        PostResponseBody response = postRequest(CREATE_POST, 201, postBody)
                .body().jsonPath().getObject("", PostResponseBody.class);
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getTitle().isEmpty());
        assertFalse(response.getBody().isEmpty());
        assertFalse(response.getDescription().isEmpty());
    }
    @Test
    public void successDraftPostCreating() {
        PostRequestBody postBody = PostRegistry.getNormalDraftPost();
        PostResponseBody response = postRequest(CREATE_POST, 201, postBody)
                .body().jsonPath().getObject("", PostResponseBody.class);
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getTitle().isEmpty());
        assertFalse(response.getBody().isEmpty());
        assertFalse(response.getDescription().isEmpty());
    }
    @Test
    public void successPostCreatingForDeleting() {
        PostRequestBody postBody = PostRegistry.getNormalForDeletingPost();
        PostResponseBody response = postRequest(CREATE_POST, 201, postBody)
                .body().jsonPath().getObject("", PostResponseBody.class);
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getTitle().isEmpty());
        assertFalse(response.getBody().isEmpty());
        assertFalse(response.getDescription().isEmpty());
    }
    @Test
    public void creatingPostWithEmptyTitle() {
        PostRequestBody postBody = PostRegistry.getNormalNonDraftPostWithEmptyTitle();
        ErrorResponseBodyByCreatingPost response = postRequest(CREATE_POST, 400, postBody)
                .body().jsonPath().getObject("", ErrorResponseBodyByCreatingPost.class);
        assertTrue(response.getTitle().get(0).contains("Title can not be empty!"));
        assertTrue(response.getTitle().get(1).contains("Title must contain from 1 to 40 characters"));
    }
}
