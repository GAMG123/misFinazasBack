package com.finanzas.sf.dto;

import lombok.Data;

@Data
public class UserLoginResponseDTO {

	private Long idUser;
	private String name;
	private String lastName;
	private String token;
}
