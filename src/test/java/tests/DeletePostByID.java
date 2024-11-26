package tests;

import dto.PostRegistry;
import dto.PostRequestBody;
import dto.PostResponseBodyByID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.GET_POST_BY_ID;
import static tests.UtilUrl.UPDATE_POST_BY_ID;


public class DeletePostByID extends BaseTest {
    @Test
    public void successDeletePostById() {
        String postId = "7b60d6f3-b895-47df-8e86-41863fe54674";
        deleteRequestWithParam(GET_POST_BY_ID, 204,"id",postId);

    }

}