package com.app.demo1.contoller;

import com.app.demo1.Services.DateServices;
import com.app.demo1.data.DateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//get  localhost:8080/date/dateFormat="02/02/2021"
// format = DD/MM/YYYY
@RestController
@RequestMapping(value ="/date")
public class DateController {

    @Autowired
    DateServices dateServices;

    @GetMapping("/dateFormat={date}")
    public DateEntity dateConversion(@PathVariable String date) {
           return dateServices.dateFormat(date);
    }
}
