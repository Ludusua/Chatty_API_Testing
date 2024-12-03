package tests.post;

import dto.request.PostRegistry;
import dto.request.PostRequestBody;
import dto.response.PostResponseBodyByID;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.*;
import static tests.utils.UtilUrl.UPDATE_POST_BY_ID;


public class UpdatePostByID extends BaseTest {
    @Test
    public void successUpdatePostById() {
        String postId = "49d41464-b340-49e0-8269-1a6effd1e535";
        PostRequestBody requestUpdateBody = PostRegistry.updatedPost();
        PostResponseBodyByID response = putRequestWithParam(UPDATE_POST_BY_ID, 200, requestUpdateBody, "id", postId)
                .body().jsonPath().getObject("", PostResponseBodyByID.class);
        assertEquals(response.getId(), postId);
        assertEquals(response.getTitle(), requestUpdateBody.getTitle());
        assertEquals(response.getDescription(), requestUpdateBody.getDescription());
        assertNotEquals(response.getUpdatedAt(), response.getCreatedAt());
        assertTrue(response.isDraft());
    }

}
