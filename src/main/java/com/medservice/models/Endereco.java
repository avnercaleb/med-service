package com.medservice.models;

import javax.persistence.Embeddable;

import com.medservice.dtos.EnderecoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String complemento;
	
	public Endereco(EnderecoDto dto) {
		this.logradouro  = dto.logradouro();
		this.bairro = dto.bairro();
		this.cep = dto.cep();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.complemento = dto.complemento();
	}
	
	public void atualizarEndereco(EnderecoDto dto) {
		
		if(dto.logradouro() != null) this.logradouro = dto.logradouro();
		if(dto.bairro() != null) this.bairro = dto.bairro();
		if(dto.cep() != null) this.cep = dto.cep();
		if(dto.cidade() != null) this.cidade = dto.cidade();
		if(dto.uf() != null) this.uf = dto.uf();
		if(dto.complemento() != null) this.complemento = dto.complemento();
	}
}
