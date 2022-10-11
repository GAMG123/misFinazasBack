package com.finanzas.sf.service;

import com.finanzas.sf.constants.Constants;
import com.finanzas.sf.dto.ResumeDTO;
import com.finanzas.sf.errorhandler.GenericServerException;
import com.finanzas.sf.model.Expenses;
import com.finanzas.sf.model.Income;
import com.finanzas.sf.model.User;
import com.finanzas.sf.repository.ExpensesRepository;
import com.finanzas.sf.repository.IncomeRepository;
import com.finanzas.sf.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
	
    final ExpensesRepository expensesRepository;
    final IncomeRepository incomeRepository;
    final UserRepository userRepository;
    
    @Override
    public ResumeDTO getResume(Long idUser) {
        ResumeDTO listResumeDTO=new ResumeDTO();
        
        User user =userRepository.findUserByIdUserAndState(idUser, Constants.RESOURCE_ACTIVE).orElseThrow(() ->
        new GenericServerException("Error not Found User"));
        
        List<Expenses> listExpenses = expensesRepository.findExpensesByUserAndState(user, Constants.RESOURCE_ACTIVE);
        List<Income> listIncome = incomeRepository.findIncomeByUserAndState(user, Constants.RESOURCE_ACTIVE);
        
        double totalIncome = 0;
        for(Income income : listIncome) {
        	totalIncome = totalIncome + income.getAmount();
        }
        
        double totalExpenses = 0;
        for(Expenses expenses : listExpenses) {
        	totalExpenses = totalExpenses + expenses.getAmount();
        }
        
        
         
        return listResumeDTO;
    }
}
