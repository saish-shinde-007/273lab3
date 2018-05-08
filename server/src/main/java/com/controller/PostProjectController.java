package com.controller;

import com.entity.Projects;
import com.service.ProjectService;
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
@RequestMapping(path="/operations")
public class PostProjectController {
    @Autowired
    private ProjectService postservice;
    @PostMapping(path="/postproject",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("project posted is ");
        System.out.println(postservice.postproj((jsonObject.getString("projectname")),(jsonObject.getString("skills")),(jsonObject.getString("ProjectDecription")),(jsonObject.getString("budget")));

        List<Projects> Projects = postservice.postproj((jsonObject.getString("projectname")),(jsonObject.getString("skills")),(jsonObject.getString("ProjectDecription")),(jsonObject.getString("budget")));
        return new ResponseEntity(Projects,HttpStatus.OK);
    }


    @GetMapping(path="/dashboard",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("in dashboard ");
        System.out.println(postservice.postproj((jsonObject.getString("projectname")),(jsonObject.getString("skills")),(jsonObject.getString("ProjectDecription")),(jsonObject.getString("budget")));

        List<Projects> Projects = postservice.postproj((jsonObject.getString("projectname")),(jsonObject.getString("skills")),(jsonObject.getString("ProjectDecription")),(jsonObject.getString("budget")));
        return new ResponseEntity(Projects,HttpStatus.OK);
    }

    @GetMapping(path="/myprojects",produces = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> myprojects (@RequestBody Projects projects) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        projects.getProject();
        projects.getSkills();
        projects.getProjectDescription();
        projects.getBudget();
        projects.getEmployer();
        return new ResponseEntity(null,HttpStatus.OK);
    }
}
