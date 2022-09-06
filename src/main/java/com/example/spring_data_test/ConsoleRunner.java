package com.example.spring_data_test;

import com.example.spring_data_test.models.Account;
import com.example.spring_data_test.models.User;
import com.example.spring_data_test.services.AccountService;
import com.example.spring_data_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Создадим пользователя
        User user = new User("Neo",21);
        // Используя сервисы зарегиструем пользователя с начальным счетом
        // Сервис через репозитории добавит пользователя и счет в базу данных
        userService.registerUser(user);
        long accountId = accountService.registerAccountForUser(user, BigDecimal.valueOf(30000));
        // Поиграемся со счетом пользователеля
        accountService.withdrawnMoney(new BigDecimal("20000"),accountId);
        accountService.transferMoney(new BigDecimal("30000"),accountId);
        Account account = accountService.getInfoAboutAccountById(accountId);
        System.out.println(account.getBalance());
    }
}
