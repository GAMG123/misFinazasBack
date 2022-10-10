package com.finanzas.sf.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExpensesResponseDTO {
	private Double expenses;
	private List<IncomeExpensesCategoryDTO> incomeCategoryDTO;
	private List<IncomeExpensesDetailDTO> incomeDetailDTO;
}
