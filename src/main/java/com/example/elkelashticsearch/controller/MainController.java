package com.example.elkelashticsearch.controller;

import com.example.elkelashticsearch.model.User;
import com.example.elkelashticsearch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/")
public class MainController {

    @Autowired
    UserService userService;

    Logger logger= LoggerFactory.getLogger(MainController.class);


    @GetMapping("/{id}")
    public Object getInformationById(@PathVariable("id") Integer id){


       Optional<User> users=userService.getUserInformationById(id);


        User user=users.stream().
                filter(u->u.getId()==id).findAny().orElse(null);

        if(user!=null){
            logger.info("user found : {}",user.getName());
            return user;
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("User Not Found with ID : {}",id);
            }
            return users;
        }

    }

    @PostMapping("/save")
    public User saveInformation(@RequestBody User teacherInformation){

        return userService.saveUserInformation(teacherInformation);
    }


    @GetMapping("/all")
    public List<User> getInformationAll(){

        return userService.getUserAll();
    }

}
