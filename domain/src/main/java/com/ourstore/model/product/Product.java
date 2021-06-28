package com.ourstore.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ourstore.model.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private String expDate;

    private String name;

    private Double price;

    private Integer quantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Order> orders;
}
