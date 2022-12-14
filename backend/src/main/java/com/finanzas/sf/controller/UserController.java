package com.finanzas.sf.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.sf.constants.Constants;
import com.finanzas.sf.dto.CodeUserDTO;
import com.finanzas.sf.dto.SaveUserRequestDTO;
import com.finanzas.sf.dto.UserLoginRequestDTO;
import com.finanzas.sf.dto.UserLoginResponseDTO;
import com.finanzas.sf.security.JwtProvider;
import com.finanzas.sf.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION + Constants.RESOURCE_USUARIO)
public class UserController {
	
	final UserService userService;
	final JwtProvider jwtProvider;
	
	@PostMapping(Constants.RESOURCE_USUARIO_LOGIN)
    public ResponseEntity<UserLoginResponseDTO> usuarioLogin(@Valid @RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        CodeUserDTO dto = this.userService.getEmailUser(userLoginRequestDTO.getEmailUsuario());
        final String token = this.jwtProvider.createToken(dto.getIdUser(), new ArrayList<>());
        return new ResponseEntity<>(userService.loginUser(userLoginRequestDTO,token),HttpStatus.OK);
    }
	
	@PostMapping(Constants.RESOURCE_USUARIO_GUARDAR)
	public ResponseEntity<?> saveUser(@Valid @RequestBody SaveUserRequestDTO saveUserRequestDTO,@RequestHeader(value = Constants.REQ_HEADER_AUTHORIZATE) String token) {
		userService.saveUser(saveUserRequestDTO,token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
