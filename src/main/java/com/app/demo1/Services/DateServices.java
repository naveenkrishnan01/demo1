package com.app.demo1.Services;

import com.app.demo1.data.DateEntity;
import com.app.demo1.jpa.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DateServices {

    @Autowired
    DateRepository dateRepository;

    public DateEntity dateFormat(String date1) {
        DateEntity ent = new DateEntity();
        ent.setDate1(ent.getDate1());
        return ent;

    }
}
