package com.medservice.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.medservice.dtos.MedicoAtualizacaoDto;
import com.medservice.dtos.MedicoDto;
import com.medservice.dtos.MedicoListagemDto;
import com.medservice.models.Medico;
import com.medservice.services.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<MedicoDto> cadastrarMedico(@RequestBody @Valid MedicoDto dto, UriComponentsBuilder uriBuilder) {
		Medico medico = new Medico(dto);
		service.cadastraMedico(dto);
		URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri(); 
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<MedicoListagemDto>> listarMedicos(@PageableDefault(size = 10, sort = "nome") Pageable page) {
		return ResponseEntity.ok(service.listarMedicos(page));
	}
	
	@PutMapping
	@Transactional
	public void atualizarMedico(@RequestBody MedicoAtualizacaoDto dto) {
		service.atualizarMedico(dto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
		service.deletarMedico(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> detalhaMedico(@PathVariable Long id) {
		return ResponseEntity.ok(service.detalhaMedico(id));
	}
}
