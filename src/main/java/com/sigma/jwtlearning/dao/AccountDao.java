package com.sigma.jwtlearning.dao;

import com.sigma.jwtlearning.domain.Account;
import com.sigma.jwtlearning.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AccountDao {
    private final JdbcTemplate template;

    public boolean insert(Account account) {
        String statement = "insert into accounts(email, username, password, roles) values (?,?,?,?)";
        return template.update(statement,
                account.getEmail(),
                account.getUsername(),
                account.getPassword(),
                account.getAuthorities().toString().replace("[", "").replace("]", "")
        ) > 0;
    }

    public List<Account> list() {
        String statement = "select * from accounts";
        return template.query(statement, new AccountMapper());
    }

    public Account findUsingEmail(String email) {
        String statement = "select * from accounts where email=?";
        return template.queryForObject(statement, new AccountMapper(), email);
    }
}
