package com.app.demo1.data;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id")
      private Integer id;

      @Column(name="first_name")
      @NotBlank
      private String firstName;
      @NotBlank
      @Column(name ="last_name")
      private String lastName;

    public UserEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public  UserEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
