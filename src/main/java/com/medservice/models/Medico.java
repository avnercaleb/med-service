package com.medservice.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.medservice.dtos.MedicoAtualizacaoDto;
import com.medservice.dtos.MedicoDto;
import com.medservice.enums.Especialidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MEDICOS")
@Data
@NoArgsConstructor
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String nome;	
	private String email;	
	private String crm;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private Endereco endereco;
	
	public Medico(MedicoDto dto) {
		this.nome = dto.nome();
		this.email = dto.email();
		this.crm = dto.crm();
		this.especialidade = dto.especialidade();
		this.endereco = new Endereco(dto.endereco());
	}
	
	public void atualizarDados(MedicoAtualizacaoDto dto) {
		
		if(dto.nome() != null) this.nome = dto.nome();
		if(dto.email() != null) this.email = dto.email();
		if(dto.endereco() != null) this.endereco.atualizarEndereco(dto.endereco());
	}
}
