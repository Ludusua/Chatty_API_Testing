package tests;

import com.github.javafaker.Faker;
import dto.LoginUserRequest;
import dto.RegistrationUserRequest;
import dto.RegistrationUserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static tests.BaseTest.postRequestWithoutToken;
import static tests.UtilUrl.USER_LOGIN;
import static tests.UtilUrl.USER_REGISTRATION;

public class LoginUserTest {
    @Test
    public void successUserLogin() {
        String email = "wyatt.kihn@yahoo.com";
        String password = "rukalevaja12";

        LoginUserRequest requestBody = new LoginUserRequest(email,password);
        RegistrationUserResponse response = postRequestWithoutToken(USER_LOGIN,200,requestBody)
                .body().jsonPath().getObject("", RegistrationUserResponse.class);
        assertFalse(response.getAccessToken().isEmpty());
        assertFalse(response.getRefreshToken().isEmpty());
        assertNotNull(response.getExpiration());
    }
}
