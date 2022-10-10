package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntityNotFoundException extends RuntimeException {


	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message) {
		super(message);
		log.error(message);
	}
}
