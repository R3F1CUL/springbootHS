package com.r3f1cul.hello;

import org.apache.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    private static final org.apache.log4j.Logger LOGGER = LogManager.getLogger(HelloController.class);

    @RequestMapping(value="/",  method=RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable String username, @PathVariable String password) {
        LOGGER.info("Inside login method...");
        if (!StringUtils.isEmpty(username) && (!StringUtils.isEmpty(password))) {
            return "Your usernmae is " + username + " and your password is " + password;
        }
        return "Fail";
    }

}