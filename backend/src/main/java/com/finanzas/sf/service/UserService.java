package com.finanzas.sf.service;

import com.finanzas.sf.dto.CodeUserDTO;
import com.finanzas.sf.dto.SaveUserRequestDTO;
import com.finanzas.sf.dto.UserLoginRequestDTO;
import com.finanzas.sf.dto.UserLoginResponseDTO;

public interface UserService {

	CodeUserDTO getEmailUser(String codigoUsuario);
	
	UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO, String token);
	void saveUser(SaveUserRequestDTO saveUserRequestDTO);
}
