package dto;

import com.github.javafaker.Faker;

public class PostRegistry {
    private PostRegistry() {
    }


    public static PostRequestBody getNormalNonDraftPost() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequestBody post = new PostRequestBody();
        post.setTitle("Created with Rest Assured");
        post.setDescription("First post created with Rest Assured");
        post.setBody(paragraph);
        post.setImageUrl("");
        post.setPublishDate("2024-11-25 19:18");
        post.setDraft(false);
        return post;
    }
    public static PostRequestBody getNormalForDeletingPost() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequestBody post = new PostRequestBody();
        post.setTitle("Created post specially for deleting");
        post.setDescription("Created post specially for deleting");
        post.setBody(paragraph);
        post.setImageUrl("");
        post.setPublishDate("2024-11-26 19:18");
        post.setDraft(false);
        return post;
    }
    public static PostRequestBody getNormalDraftPost() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequestBody post = new PostRequestBody();
        post.setTitle("Created with Rest Assured");
        post.setDescription("First post created with Rest Assured");
        post.setBody(paragraph);
        post.setImageUrl("");
        post.setPublishDate("2024-11-25 19:18");
        post.setDraft(true);
        return post;
    }

    public static PostRequestBody updatedPost() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequestBody post = new PostRequestBody();
        post.setTitle("Updated post");
        post.setDescription("First post created and updated with Rest Assured");
        post.setBody(paragraph);
        post.setDraft(true);
        return post;
    }
    public static PostRequestBody getNormalNonDraftPostWithEmptyTitle() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        PostRequestBody post = new PostRequestBody();
        post.setTitle("");
        post.setDescription("First post created with Rest Assured");
        post.setBody(paragraph);
        post.setImageUrl("");
        post.setPublishDate("2024-11-25 19:18");
        post.setDraft(false);
        return post;
    }
}
