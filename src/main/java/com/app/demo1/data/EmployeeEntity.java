package com.app.demo1.data;


import javax.persistence.*;

@Entity
@Table(name = "employeeOk")
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column(name="employee_id")
    private Integer employeeId;

    @Column(name="employee_name")
    private String  emplyeeName;

    @Column(name="full_time")
    private String fullTime;


    public String getEmplyeeName() {
        return emplyeeName;
    }

    public void setEmplyeeName(String emplyeeName) {
        this.emplyeeName = emplyeeName;
    }

    public String getFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "emplyeeName='" + emplyeeName + '\'' +
                ", fullTime=" + fullTime +
                '}';
    }
}
