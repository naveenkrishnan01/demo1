package com.app.demo1.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity()
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Integer orderId;
    private String orderDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserEntity userOrder;

    public OrderEntity(Integer orderId, String orderDescription) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
    }

    public OrderEntity(){

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public UserEntity getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserEntity userOrder) {
        this.userOrder = userOrder;
    }
}
