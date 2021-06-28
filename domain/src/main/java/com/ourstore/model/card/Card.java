package com.ourstore.model.card;

import com.ourstore.model.customer.Customer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cardType;

    private Integer cvv;

    private String cardName;

    private String cardNumber;

    private String expDate;

    @ManyToOne
    @ToString.Exclude
    private Customer customer;

    public void setCustomer (Customer customer) {
        if (getCustomer() == null) {
            this.customer = customer;
        }
    }
}
