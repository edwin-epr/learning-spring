package org.edwinepr.ch13transactions.repositories.mappers;

import org.edwinepr.ch13transactions.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {


    @Override
    public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Account account = new Account();
        account.setId(resultSet.getLong("id"));
        account.setName(resultSet.getString("name"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }
}
