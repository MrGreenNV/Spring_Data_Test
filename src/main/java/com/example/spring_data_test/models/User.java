package com.example.spring_data_test.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity(name = "users")
public class User {

    // Идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private int age;

    // У пользователя может быть несколько счетов
    @OneToMany(targetEntity = Account.class,mappedBy = "user")
    private Set<Account> accounts;

    public User(){}

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Список счетов возвращается как коллекция для чтения
    public Set<Account> getAccounts() {
        return Collections.unmodifiableSet(accounts);
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}

