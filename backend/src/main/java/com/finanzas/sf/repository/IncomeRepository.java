package com.finanzas.sf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.Income;
import com.finanzas.sf.model.User;

public interface IncomeRepository  extends CrudRepository<Income, Integer> {
	
	Optional<Income> findIncomeByIdIncomeAndState(Long idDatoIndicador, Boolean estado);
	List<Income> findIncomeByUserAndState(User user, Boolean state);
}
