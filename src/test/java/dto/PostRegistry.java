package dto;

import com.github.javafaker.Faker;

import java.util.List;

public class PostRegistry {
    private PostRegistry() {
    }


    public static PostRequest getNormalNonDraftPost() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequest post = new PostRequest();
        post.setTitle("Created with Rest Assured");
        post.setDescription("First post created with Rest Assured");
        post.setBody(paragraph);
        post.setImageUrl("");
        post.setPublishDate("2024-11-25 19:18");
        post.setDraft(false);
        return post;
    }
}
