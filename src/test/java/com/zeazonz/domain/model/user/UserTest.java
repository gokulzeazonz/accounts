package com.zeazonz.domain.model.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("zeazonz",new Address("","","","",""),
                new Email("hgfh@gmail.com"),
                "aa1aaA");
    }

}
