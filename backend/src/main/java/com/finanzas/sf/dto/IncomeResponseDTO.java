package com.finanzas.sf.dto;

import java.util.List;

import lombok.Data;

@Data
public class IncomeResponseDTO {

	private Double income;
	private List<IncomeExpensesCategoryDTO> incomeCategoryDTO;
	private List<IncomeExpensesDetailDTO> incomeDetailDTO;
	
}
