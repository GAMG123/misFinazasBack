package com.finanzas.sf.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.User;

public interface UserRepository extends  CrudRepository<User, Long> {
	
	public Optional<User> findUserByIdUserAndState(Long idUser, Integer estado);
	public Optional<User> findUserByEmailAndState(String email, Integer state);
}
