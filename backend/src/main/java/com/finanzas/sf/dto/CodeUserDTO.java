package com.finanzas.sf.dto;

import lombok.Data;

@Data
public class CodeUserDTO {

	private String idUser;
	
	public CodeUserDTO(String idString) {
		this.idUser = idString;
	}
}
