package tests;

import dto.LoginUserRequest;
import dto.RegistrationUserResponse;
import dto.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tests.UtilUrl.GET_USER;
import static tests.UtilUrl.USER_LOGIN;

public class GetMeRequest extends BaseTest{
    @Test
    public void getMeTest() {
        User response = getRequest(GET_USER,200)
                .body().jsonPath().getObject("", User.class);
        assertFalse(response.getId().isEmpty());
        assertEquals(response.getName(),"Vladik");
        assertEquals(response.getSurname(),"Petrenko");
        assertFalse(response.getPhone().isEmpty());
        assertFalse(response.getEmail().isEmpty());
        assertEquals(response.getRole(),"USER");
    }
}
