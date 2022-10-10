package com.finanzas.sf.service;

import com.finanzas.sf.dto.DeleteExpensesRequestDTO;
import com.finanzas.sf.dto.ExpensesResponseDTO;
import com.finanzas.sf.dto.SaveExpensesRequestDTO;

public interface ExpensesService {
    ExpensesResponseDTO getExpenses(Long idUser);
    void saveExpenses(SaveExpensesRequestDTO saveExpensesRequestDTO);
    void deleteIncome(DeleteExpensesRequestDTO DeleteExpensesRequestDTO);
}
