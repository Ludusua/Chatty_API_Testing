package tests;

import dto.PostResponseBodyByID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.*;

public class GetPostByID extends BaseTest {
    @Test
    public void successGetPostById() {
        String userId = "841d6434-4d40-4618-b6c4-6302bd8c7364";
        String postId = "49d41464-b340-49e0-8269-1a6effd1e535";
        PostResponseBodyByID response = getRequestWithParam(GET_POST_BY_ID,200,"id",postId)
                .body().jsonPath().getObject("", PostResponseBodyByID.class);
        assertEquals(response.getId(),postId);
        assertTrue(response.getTitle().contains("Created with Rest Assured"));
        assertFalse(response.isDraft());
        assertEquals(response.getUser().getId(),userId);
        assertEquals(response.getUser().getName(),"Vladik");

    }

}
