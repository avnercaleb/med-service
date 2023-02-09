package com.medservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medservice.dtos.MedicoAtualizacaoDto;
import com.medservice.dtos.MedicoDto;
import com.medservice.dtos.MedicoListagemDto;
import com.medservice.models.Medico;
import com.medservice.repositories.MedicoRepository;

@Service
public class MedicoService {
	
		
	@Autowired
	private MedicoRepository repository;
	
	public MedicoDto cadastraMedico(MedicoDto dto) {
		repository.save(new Medico(dto));
		return dto;
	}
	
	public Page<MedicoListagemDto> listarMedicos(Pageable page) {
		
		return repository.findAll(page)
				.map(MedicoListagemDto::new);
	}
	
	public void atualizarMedico(MedicoAtualizacaoDto dto) {
		Medico medico = repository.getReferenceById(dto.id());
		medico.atualizarDados(dto);
	}
	
	public void deletarMedico(Long id) {
		Medico medico = repository.getReferenceById(id);
		repository.delete(medico);
	}
	
	public Medico detalhaMedico(Long id) {
		return repository.getReferenceById(id);
	}
}
