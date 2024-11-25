package tests;

import dto.PostResponseByID;
import dto.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.UtilUrl.*;

public class GetPostByID extends BaseTest {
    @Test
    public void successGetPostById() {
        String id = "49d41464-b340-49e0-8269-1a6effd1e535";
        PostResponseByID response = getRequestWithParam(GET_POST_BY_ID,200,"id",id)
                .body().jsonPath().getObject("",PostResponseByID.class);
    }

}
