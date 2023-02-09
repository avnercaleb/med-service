package com.medservice.dtos;

import javax.validation.constraints.NotNull;

public record MedicoAtualizacaoDto(
		@NotNull
		Long id,
		String nome,
		String email,
		EnderecoDto endereco) {

}
