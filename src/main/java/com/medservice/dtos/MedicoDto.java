package com.medservice.dtos;

import javax.validation.constraints.NotBlank;

import com.medservice.enums.Especialidade;

public record MedicoDto(
		@NotBlank
		String nome,
		@NotBlank
		String email,
		@NotBlank
		String crm,
		Especialidade especialidade,
		EnderecoDto endereco) {

}
