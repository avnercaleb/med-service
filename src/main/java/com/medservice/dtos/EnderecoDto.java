package com.medservice.dtos;

public record EnderecoDto(
		String logradouro,
		String bairro,
		String cep,
		String cidade,
		String uf,
		String complemento) {}
