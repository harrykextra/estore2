package com.ourstore.model.order;

import com.ourstore.model.customer.Customer;
import com.ourstore.model.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean canceled;

    private boolean delivered;

    private String date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Product> products;
}
