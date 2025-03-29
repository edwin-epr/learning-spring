package org.edwinepr.ch14electronicwallet.repositories;

import org.edwinepr.ch14electronicwallet.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("select * from account where name = :name")
    List<Account> findAccountByName(String name);

    @Modifying
    @Query("update account set amount = :amount where id = :id")
    void changeAmount(long id, BigDecimal amount);
}
