package tests.post;

import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static tests.utils.UtilUrl.*;


public class DeletePostByID extends BaseTest {
    @Test
    public void successDeletePostById() {
        String postId = "7b60d6f3-b895-47df-8e86-41863fe54674";
        deleteRequestWithParam(DELETE_POST_BY_ID, 204,"id",postId);

    }

}
