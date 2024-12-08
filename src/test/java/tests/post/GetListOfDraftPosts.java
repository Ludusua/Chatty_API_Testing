package tests.post;

import dto.response.PostResponseBodyByID;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static tests.utils.UtilUrl.GET_DRAFT_POSTS;

public class GetListOfDraftPosts extends BaseTest {
    @Test
    public void successGetListOfDraftPosts() {
        String userId = "841d6434-4d40-4618-b6c4-6302bd8c7364";
        List<PostResponseBodyByID> allPosts = getRequest(GET_DRAFT_POSTS, 200)
                .body().jsonPath().getList("", PostResponseBodyByID.class);
        System.out.println(allPosts);
        assertEquals(2,allPosts.size());
        assertEquals(allPosts.get(0).getCreatedAt(),allPosts.get(0).getUpdatedAt());
        assertEquals(allPosts.get(1).getCreatedAt(),allPosts.get(1).getUpdatedAt());
        for (PostResponseBodyByID post:allPosts){
            assertFalse(post.getDescription().isEmpty());
            assertFalse(post.getBody().isEmpty());
            assertFalse(post.getTitle().isEmpty());
            assertEquals(post.getUser().getId(),userId);
        }
    }
}
