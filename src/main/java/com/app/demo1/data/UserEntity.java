package com.app.demo1.data;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "user")
public class UserEntity  {


      @Id
      @GeneratedValue
      @Column(name="id")
      private Integer id;

      @Column(name="first_name")
      @NotBlank
      private String firstName;
      @NotBlank
      @Column(name ="last_name")
      private String lastName;

     @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<DeptEntity> deptEntityList;

    public UserEntity(String firstName, String lastName, List<DeptEntity> deptEntityList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptEntityList = deptEntityList;
    }

    public UserEntity()  {

    }
    public  UserEntity(List<DeptEntity> deptEntityList) {

        this.deptEntityList = deptEntityList;
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
