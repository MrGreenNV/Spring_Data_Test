package com.example.spring_data_test.services;

import com.example.spring_data_test.models.Account;
import com.example.spring_data_test.models.User;

import java.math.BigDecimal;

public interface AccountService {
    Long registerAccountForUser(User user, BigDecimal money);
    Account getInfoAboutAccountById(Long id);
    void withdrawnMoney(BigDecimal money, Long id);
    void transferMoney(BigDecimal money, Long id);
}
