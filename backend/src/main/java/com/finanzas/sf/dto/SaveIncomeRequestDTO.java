package com.finanzas.sf.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SaveIncomeRequestDTO {
	
	
	private Double amount;
	private String descriptionDetail;
	private Date date;
	private Long idCategory;
	private String comment;
	private Long idAccount;        
	private Long idUse;

}
