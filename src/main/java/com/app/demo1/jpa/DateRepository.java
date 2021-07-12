package com.app.demo1.jpa;

import com.app.demo1.data.DateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DateRepository extends CrudRepository<DateEntity, Integer> {

    public static void loadDate() {
        List<DateEntity> addDate = new ArrayList<DateEntity>();
        DateEntity date1 = new DateEntity();
        date1.setDate1("12/02/2020");
        date1.setDate1("12/21/2020");
        addDate.add(date1);
    }
}
