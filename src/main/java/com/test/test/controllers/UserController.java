package com.test.test.controllers;


import com.test.test.dao.UserDao;
import com.test.test.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UserDao userDao;
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

    @RequestMapping(value = "api/usuarios")
    public List<User> getUsers(){
        return userDao.getUsers();
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
    public void delete(@PathVariable Long id){
        userDao.delete(id);
    }
    @RequestMapping(value = "usuario3")
    public User search(){
        User user = new User();
        user.setNombre("Pablo");
        user.setApellido("Montoya");
        user.setEmail("juasjuas@gmail.com");
        user.setTelefono("332112314123");
        user.setPassword("papaptapa");
        return user;
    }


}
