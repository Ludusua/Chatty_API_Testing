package tests.utils;

public class UtilUrl {

    public static final String USER_REGISTRATION = "/api/auth/register";
    public static final String USER_LOGIN = "/api/auth/login";
    public static final String GET_USER = "/api/me";
    public static final String PUT_USER_BY_ID = "/api/users/{id}";
    public static final String GET_POST_BY_ID = "/api/posts/{id}";
    public static final String DELETE_POST_BY_ID = "/api/posts/{id}";
    public static final String GET_DRAFT_POSTS = "/api/posts/drafts";
    public static final String UPDATE_POST_BY_ID = "/api/posts/{id}";
    public static final String CREATE_POST = "/api/posts";


    private UtilUrl() {

    }
}
