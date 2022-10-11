package com.finanzas.sf.service;

import com.finanzas.sf.constants.Constants;
import com.finanzas.sf.dto.CodeUserDTO;
import com.finanzas.sf.dto.SaveUserRequestDTO;
import com.finanzas.sf.dto.UserLoginRequestDTO;
import com.finanzas.sf.dto.UserLoginResponseDTO;
import com.finanzas.sf.errorhandler.GenericClientException;
import com.finanzas.sf.model.User;
import com.finanzas.sf.model.UserPass;
import com.finanzas.sf.repository.UserPassRepository;
import com.finanzas.sf.repository.UserRepository;
import com.finanzas.sf.util.Util;
import com.finanzas.sf.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	final Util util;
	final UserRepository userRepository;
	final UserPassRepository userPassRepository;
	final JwtUtil jwtUtil;
	
	@Override
	public CodeUserDTO getEmailUser(String emailUser) {
		if(Boolean.FALSE.equals(util.validateUser(emailUser))) {
			throw new GenericClientException("Correo de Usuario es invalido", HttpStatus.BAD_REQUEST);
		}
		return new CodeUserDTO(emailUser);
	}

	@Override
	public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO, String token) {
		if(Boolean.FALSE.equals(util.validateUser(userLoginRequestDTO.getEmailUsuario()))) {
			throw new GenericClientException("Correo de Usuario es invalido", HttpStatus.BAD_REQUEST);
		}
//		boolean resultLogin=false;
//        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		Optional<User> optionalUsuario= userRepository.findUserByEmailAndState(userLoginRequestDTO.getEmailUsuario(), Constants.RESOURCE_ACTIVE);
		User user = optionalUsuario.orElseThrow(()->new GenericClientException("Coreo o contraseña incorrectos", HttpStatus.FORBIDDEN));
		
//		try{
//	        resultLogin=passwordEncoder.matches(usuarioLoginRequestDTO.getContrasenaUsuario(), usuario.getUsuarioContrasenia().getContrasenia());
//	        }catch(NullPointerException ex){
//	            throw new C4fGenericServerException("Error de acceso al password");
//	        }
//	        if(!resultLogin){
//	            throw new C4fGenericClientException("Codigo o contraseña incorrectos", HttpStatus.FORBIDDEN);
//	        }
//		
		
		UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
		userLoginResponseDTO.setLastName(user.getLastName());
		userLoginResponseDTO.setIdUser(user.getIdUser());
		userLoginResponseDTO.setName(user.getName());
		userLoginResponseDTO.setToken(token);
		return userLoginResponseDTO;
	}

	@Override
	public void saveUser(SaveUserRequestDTO saveUserRequestDTO) {
//		String myToken = token.substring(7);
//        String idUsertSession = jwtUtil.getUsernameFromToken(myToken);
        
        User user = new User();
        user.setName(saveUserRequestDTO.getName());
        user.setLastName(saveUserRequestDTO.getLastName());
        user.setEmail(saveUserRequestDTO.getEmail());
        user.setPhone(saveUserRequestDTO.getPhone());
        user.setState(Constants.RESOURCE_ACTIVE);
        user.setRegistrationDate(new Date());
        userRepository.save(user);
        
        UserPass uc= new UserPass();
        uc.setUser(user);
        uc.setPass(saveUserRequestDTO.getPass());
        uc.setState(Constants.RESOURCE_ACTIVE);
        uc.setRegistrationDate(new Date());
        userPassRepository.save(uc);
        
        
        
	}

}
