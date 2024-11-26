package tests;

import dto.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static tests.UtilUrl.PUT_USER_BY_ID;

public class EditUserByID extends BaseTest{

    @Test
    public void successUserEdit() {
        String name = "Vladik";
        String surname = "Petrenko";
        String phone = "+49982871061";
        String gender = "MALE";
        String id = "841d6434-4d40-4618-b6c4-6302bd8c7364";
        User requestBodyBuilder = User.builder().name(name).surname(surname).phone(phone).gender(gender).build();
        User response = putRequestWithParam(PUT_USER_BY_ID,200,requestBodyBuilder,"id",id)
                .body().jsonPath().getObject("", User.class);
        assertFalse(response.getEmail().isEmpty());
        assertFalse(response.getName().isEmpty());
        assertFalse(response.getSurname().isEmpty());
        assertFalse(response.getPhone().isEmpty());
    }
}
