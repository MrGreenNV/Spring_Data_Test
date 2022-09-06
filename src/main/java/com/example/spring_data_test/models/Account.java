package com.example.spring_data_test.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "accounts")
public class Account {

    // Идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    // У счета может быть только один пользователь-владелец
    @ManyToOne
    private User user;

    public Account(){}

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

