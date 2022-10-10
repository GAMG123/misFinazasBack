package com.finanzas.sf.dto;

import lombok.Data;

@Data
public class SaveUserRequestDTO {
	
	private String idUser;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	private String pass;

}
