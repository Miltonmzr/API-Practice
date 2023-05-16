package com.test.test.controllers;


import com.test.test.dao.UserDao;
import com.test.test.models.User;
import com.test.test.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setNombre("Pablo");
        user.setApellido("Montoya");
        user.setEmail("juasjuas@gmail.com");
        user.setTelefono("332112314123");
        user.setPassword("papaptapa");
        return user;
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value = "Authorization") String token){
        if(!validateToken(token)){return null;}
        return userDao.getUsers();
    }

    private boolean validateToken(String token){
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash =  argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
    }

    @RequestMapping(value = "usuario1")
    public User edit(){
        User user = new User();
        user.setNombre("Pablo");
        user.setApellido("Montoya");
        user.setEmail("juasjuas@gmail.com");
        user.setTelefono("332112314123");
        user.setPassword("papaptapa");
        return user;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validateToken(token)){return;}
        userDao.delete(id);
    }


}
