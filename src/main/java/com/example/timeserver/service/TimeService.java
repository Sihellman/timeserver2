package com.example.timeserver.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TimeService {
    public String getTime(){
        Date date = new Date();
        return date.toString();
    }

    public Long getEpochTime(){
        Date date = new Date();
        return date.getTime();
    }
    public LocalDateTime getUTCTime(String zone){
        return  LocalDateTime.ofInstant(Instant.now(), ZoneId.of(zone));
    }
}
