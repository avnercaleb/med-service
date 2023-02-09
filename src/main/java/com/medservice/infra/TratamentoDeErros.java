package com.medservice.infra;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> handlerError404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErroValidacao>> handlerError400(MethodArgumentNotValidException ex) {
		
		List<FieldError> errorList = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(errorList
				.stream()
				.map(DadosErroValidacao::new).toList());
	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}
