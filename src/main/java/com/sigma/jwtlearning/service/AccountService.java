package com.sigma.jwtlearning.service;

import com.sigma.jwtlearning.dao.AccountDao;
import com.sigma.jwtlearning.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountDao accountDao;

    public boolean insert(Account account) {
        return accountDao.insert(account);
    }

    public Account findUsingEmail(String email) {
        return accountDao.findUsingEmail(email);
    }

    public List<Account> list() {
        return accountDao.list();
    }
}
