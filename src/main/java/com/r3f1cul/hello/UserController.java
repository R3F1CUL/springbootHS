package com.r3f1cul.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by R3F1CUL on 5/23/2015.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String[] getAllUsers() {
        String users[] = {"Ankit", "Bohra", "Xyz"};
        return users;
    }
}
