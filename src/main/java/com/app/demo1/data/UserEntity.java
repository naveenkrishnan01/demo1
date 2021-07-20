package com.app.demo1.data;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "user")
public class UserEntity extends RepresentationModel<UserEntity> {


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

      @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<OrderEntity> orders;

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

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
