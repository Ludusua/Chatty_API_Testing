package tests;

import dto.PostRegistry;
import dto.PostRequest;
import dto.PostResponseByID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.UPDATE_POST_BY_ID;


public class UpdatePostByID extends BaseTest {
    @Test
    public void successUpdatePostById() {
        String postId = "49d41464-b340-49e0-8269-1a6effd1e535";
        PostRequest requestUpdateBody = PostRegistry.updatedPost();
        PostResponseByID response = putRequestWithParam(UPDATE_POST_BY_ID, 200, requestUpdateBody, "id", postId)
                .body().jsonPath().getObject("", PostResponseByID.class);
        assertEquals(response.getId(), postId);
        assertEquals(response.getTitle(), "Updated post");
        assertEquals(response.getDescription(), requestUpdateBody.getDescription());
        assertNotEquals(response.getUpdatedAt(), response.getCreatedAt());
        assertTrue(response.isDraft());
    }

}
