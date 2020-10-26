package com.example.timeserver.controller;

import com.example.timeserver.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime(){
        return timeService.getTime();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime(){
        return timeService.getEpochTime();
    }

    @GetMapping("/UTCTime")
    public LocalDateTime getUTCTime(){
        try {
            return timeService.getUTCTime("Asia/Jerusalem");
        } catch (DateTimeException exc) {
            System.out.println("not a zone");
            throw exc;
        }

    }
}
