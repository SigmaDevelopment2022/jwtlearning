package com.sigma.jwtlearning.mapper;


import com.sigma.jwtlearning.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Account.builder()
                .id(rs.getLong("id"))
                .email(rs.getString("email"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .authorities(rs.getString("roles"))
                .created(rs.getString("created"))
                .build();
    }
}
