package com.finanzas.sf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
	@NotNull
    @NotBlank
    @NotEmpty
    private String emailUsuario;
	
	@NotNull
    @NotBlank
    @NotEmpty
    private String contraseniaUsuario;
}
