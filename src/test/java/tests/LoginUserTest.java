package tests;

import dto.LoginUserRequestBody;
import dto.RegistrationUserResponseBody;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static tests.BaseTest.postRequestWithoutToken;
import static tests.UtilUrl.USER_LOGIN;

public class LoginUserTest {
    @Test
    public void successUserLogin() {
        String email = "wyatt.kihn@yahoo.com";
        String password = "rukalevaja12";

        LoginUserRequestBody requestBody = new LoginUserRequestBody(email,password);
        RegistrationUserResponseBody response = postRequestWithoutToken(USER_LOGIN,200,requestBody)
                .body().jsonPath().getObject("", RegistrationUserResponseBody.class);
        assertFalse(response.getAccessToken().isEmpty());
        assertFalse(response.getRefreshToken().isEmpty());
        assertNotNull(response.getExpiration());
    }
}
