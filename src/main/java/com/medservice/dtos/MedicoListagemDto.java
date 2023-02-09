package com.medservice.dtos;

import com.medservice.enums.Especialidade;
import com.medservice.models.Medico;

public record MedicoListagemDto(
		Long id,
		String nome,
		String email,
		String crm,
		Especialidade especialidade) {
		
	public MedicoListagemDto(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
