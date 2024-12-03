package tests.registration;

import com.github.javafaker.Faker;
import dto.request.RegistrationUserRequestBody;
import dto.response.RegistrationUserResponseBody;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.*;
import static tests.utils.UtilUrl.USER_REGISTRATION;

public class RegistrationUserTest extends BaseTest {

    @Test
    public void successUserRegistration() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = "rukalevaja12";
        String confirmPpassword = password;
        String role = "user";

        RegistrationUserRequestBody requestBody = new RegistrationUserRequestBody(email,password,confirmPpassword,role);
        RegistrationUserResponseBody response = postRequestWithoutToken(USER_REGISTRATION,201,requestBody)
                .body().jsonPath().getObject("", RegistrationUserResponseBody.class);
        assertFalse(response.getAccessToken().isEmpty());
        assertFalse(response.getRefreshToken().isEmpty());
        assertNotNull(response.getExpiration());
    }
}