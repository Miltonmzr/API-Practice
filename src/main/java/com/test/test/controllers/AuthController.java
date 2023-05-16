package com.test.test.controllers;

import com.test.test.dao.UserDao;
import com.test.test.models.User;
import com.test.test.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtutil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){

        User userLoggedIn = userDao.getUserByCredentials(user);
        if(userLoggedIn != null){

            String tokenJwt = jwtutil.create(String.valueOf(userLoggedIn.getId()), userLoggedIn.getEmail());

            return tokenJwt;
        }
        return "Fail";
    }

}
