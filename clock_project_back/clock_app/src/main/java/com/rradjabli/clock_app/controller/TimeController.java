package com.rradjabli.clock_app.controller;

import com.rradjabli.clock_app.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    TimeService timeService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/time")
    public String getDefaultTime(){
        String time = timeService.getTime();
        return time;
    }

}
