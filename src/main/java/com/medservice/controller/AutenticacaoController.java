package com.medservice.controller;

import javax.validation.Valid;

import com.medservice.infra.security.DadosTokenJwt;
import com.medservice.infra.security.TokenService;
import com.medservice.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medservice.dtos.UsuarioDto;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDto dto) {
		var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
		var authentication = manager.authenticate(authToken);

		var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

		return ResponseEntity.ok(new DadosTokenJwt(tokenJWT));
	}
}
