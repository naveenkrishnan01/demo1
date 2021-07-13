package com.app.demo1.Services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.Locale;


@Service
public class DateServices {


    public String dateServiceConversion(String date1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(date1, formatter);
        String weekOfDay = date.getDayOfWeek().toString();
        return weekOfDay;
    }

    }

