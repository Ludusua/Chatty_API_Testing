package tests;

import dto.PostResponseByID;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.GET_DRAFT_POSTS;

public class GetListOfDraftPosts extends BaseTest {
    @Test
    public void successGetListOfDraftPosts() {
        String userId = "841d6434-4d40-4618-b6c4-6302bd8c7364";
        List<PostResponseByID> allPosts = getRequest(GET_DRAFT_POSTS, 200)
                .body().jsonPath().getList("", PostResponseByID.class);
        System.out.println(allPosts);
        assertEquals(2,allPosts.size());
        assertNotEquals(allPosts.get(0).getCreatedAt(),allPosts.get(0).getUpdatedAt());
        assertEquals(allPosts.get(1).getCreatedAt(),allPosts.get(1).getUpdatedAt());
        for (PostResponseByID post:allPosts){
            assertFalse(post.getDescription().isEmpty());
            assertFalse(post.getBody().isEmpty());
            assertFalse(post.getTitle().isEmpty());
            assertEquals(post.getUser().getId(),userId);
        }
    }
}
