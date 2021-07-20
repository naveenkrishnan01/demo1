package com.app.demo1.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class DateEntity {


    @GeneratedValue
    private Integer Id;
    private String date1;

    public DateEntity() {
        this.Id = Id;
        this.date1 = date1;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
