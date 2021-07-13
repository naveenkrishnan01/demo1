package com.app.demo1.contoller;

import com.app.demo1.Services.DateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/test")
public class DateController {
    @Autowired
    DateServices dateServices;

    @GetMapping(params = "date1") // format - YYYY/MM/DD
    public String getDateFormat(@RequestParam @DateTimeFormat(pattern="yyyy/MM/dd") String date1) {
        return dateServices.dateServiceConversion(date1);
    }
}
