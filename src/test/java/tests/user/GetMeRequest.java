package tests.user;

import dto.User;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.*;
import static tests.utils.UtilUrl.GET_USER;

public class GetMeRequest extends BaseTest {
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
