package com.server.test;

import com.entity.User;
import com.entity.Project;
import com.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreelancerTest {

    @Autowired
    UserService userService;
    ProjectService projectService;
    public void setUp(){

    }

    public void tearDown(){

    }

    @Test
    public void UserLoginTrue() {
        List<User> userList = userService.login("saish.shinde@sjsu.edu",userService.generateHash("1234"));
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void FindUserByEmail() {
        List<User> userList = userService.findByEmail("saish.shinde@sjsu.edu");
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void findUsers()
    {
        Iterable<Project> ProjectList;
        ProjectList = projectService.getAllProjects();
        System.out.println(ProjectList);
        if(ProjectList.spliterator().getExactSizeIfKnown()>0)
        {
        assert true;
        }

        else {
            assert false;
        }
    }
    @Test
    public void UserLoginFalse() {
        List<User> userList = userService.login("j@j.com",userService.generateHash("j"));
        System.out.println(userList);
        if(userList.size()==0){
            assert true;
        }
        else {
            assert false;
        }
    }


    @Test
    public void getUserProfile() {
        User user = profileService.fetchProfile("saish.shinde@sjsu.edu");
        System.out.println(user);
        if(user!=null){
            assert true;
        }
        else {
            assert false;
        }
    }


}
