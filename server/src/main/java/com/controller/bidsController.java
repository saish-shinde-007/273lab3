package com.controller;

import com.entity.Bids;
import com.service.BidsService;
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
public class bidsController {
    @Autowired
    private BidsService BidsService;
    @PostMapping(path="/bids",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("project posted is ");
       System.out.println (BidsService.postbid((jsonObject.getString("projectname")),(jsonObject.getString("bids")),(jsonObject.getString("period"))));

       List<Bids> Bids = BidsService.postbid((jsonObject.getString("projectname")),(jsonObject.getString("bids")),(jsonObject.getString("period"))));
        return new ResponseEntity(Bids, HttpStatus.OK);
    }
}
