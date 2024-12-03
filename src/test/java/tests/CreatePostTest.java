package tests;

import dto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilResponseData.*;
import static tests.UtilUrl.CREATE_POST;


public class CreatePostTest extends BaseTest{
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
        ErrorResponseBodyByPostTitle response = postRequest(CREATE_POST, 400, postBody)
                .body().jsonPath().getObject("", ErrorResponseBodyByPostTitle.class);
        assertTrue(response.getTitle().get(0).contains(EMPTY_TITLE_RESPONSE));
        assertTrue(response.getTitle().get(1).contains(INVALID_TITLE_RESPONSE));
    }
    @Test
    public void creatingPostWithEmptyDescription() {
        PostRequestBody postBody = PostRegistry.getNormalNonDraftPostWithEmptyDescription();
        ErrorResponseBodyByPostDescription response = postRequest(CREATE_POST, 400, postBody)
                .body().jsonPath().getObject("", ErrorResponseBodyByPostDescription.class);
        assertTrue(response.getDescription().get(0).contains(EMPTY_DESCRIPTION_RESPONSE));
        assertTrue(response.getDescription().get(1).contains(INVALID_DESCRIPTION_RESPONSE));
    }

}
