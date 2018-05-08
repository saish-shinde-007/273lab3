package com.controller;

import com.entity.User;
import com.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import javax.servlet.http.HttpSession;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/operations") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(path="/hello")
    public String hello(){
        return "Hello!";

    }

    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("password is ");
        System.out.println(userService.generateHash(jsonObject.getString("password")));

       List<User> users  = userService.login(jsonObject.getString("email"),(jsonObject.getString("password")));
        System.out.println("user length is "+users);

     session.setAttribute("name",jsonObject.getString("name"));
        if(users.size()>0)
            session.setAttribute("id",users.get(0).getId());
        return new ResponseEntity(users.get(0),HttpStatus.OK);
    }

    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String receivedPass = user.getPassword();
        String newPass = userService.generateHash(receivedPass);
        user.setPassword(newPass);
        userService.addUser(user);
        System.out.println("user is "+user.getId());
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @PostMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> update (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String receivedPass = user.getPassword();
        String newPass = userService.generateHash(receivedPass);
        user.setPassword(newPass);
        userService.addUser(user);
        System.out.println("user is "+user.getId());
        return new ResponseEntity(null,HttpStatus.CREATED);
    }


    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }
}
