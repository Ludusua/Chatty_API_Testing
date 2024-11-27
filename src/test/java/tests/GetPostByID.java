package tests;

import dto.ErrorResponseBody;
import dto.PostResponseBodyByID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.*;

public class GetPostByID extends BaseTest {
    @Test
    public void successGetPostById() {
        String userId = "841d6434-4d40-4618-b6c4-6302bd8c7364";
        String postId = "31a9feee-c79d-4f9c-a749-2dcc3fab6428";
        PostResponseBodyByID response = getRequestWithParam(GET_POST_BY_ID,200,"id",postId)
                .body().jsonPath().getObject("", PostResponseBodyByID.class);
        assertEquals(response.getId(),postId);
        assertTrue(response.getTitle().contains("Created with Rest Assured"));
        assertFalse(response.isDraft());
        assertEquals(response.getUser().getId(),userId);
        assertEquals(response.getUser().getName(),"Vladik");
    }

    @Test
    public void getPostByInvalidId() {
        String invalidPostId = "31a9ee-4f9c-a749-2dcc3fab6428";
        ErrorResponseBody response = getRequestWithParam(GET_POST_BY_ID,500,"id",invalidPostId)
                .body().jsonPath().getObject("", ErrorResponseBody.class);
        assertEquals(response.getHttpStatus(),"INTERNAL_SERVER_ERROR");
        assertTrue(response.getMessage().contains("Invalid UUID string"));
    }

}
