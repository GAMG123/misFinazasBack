package com.finanzas.sf.repository;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.Account;
import com.finanzas.sf.model.User;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
    List<Account> findAccountByUserAndState(User user, Boolean state);
    Optional<Account> findAccountByIdAccountAndState(Long idAccount, Boolean state);
}
