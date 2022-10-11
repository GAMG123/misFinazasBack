package com.finanzas.sf.repository;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.Expenses;
import com.finanzas.sf.model.User;

import java.util.List;
import java.util.Optional;

public interface ExpensesRepository  extends CrudRepository<Expenses, Integer> {
	
    Optional<Expenses> findExpensesByIdExpensesAndState(Long idExpenses, Integer estado);
    List<Expenses> findExpensesByUserAndState(User user, Integer estado);
    
}
