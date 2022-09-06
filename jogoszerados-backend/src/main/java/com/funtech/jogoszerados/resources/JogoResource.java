package com.funtech.jogoszerados.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.funtech.jogoszerados.domain.Jogo;
import com.funtech.jogoszerados.domain.dtos.JogoDTO;
import com.funtech.jogoszerados.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	private JogoService service;

	// Get Mapping serve para fazer requisições para buscar algo [???]
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogoDTO> findById(@PathVariable Integer id) {
		Jogo obj = service.findById(id);
		return ResponseEntity.ok().body(new JogoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<Jogo> jogos = service.findAll();
		List<JogoDTO> jogosDTO = jogos.stream().map(p -> new JogoDTO(p)).collect(Collectors.toList());

		return ResponseEntity.ok().body(jogosDTO);
	}

	@PostMapping
	public ResponseEntity<JogoDTO> create(@Valid @RequestBody JogoDTO objDTO) {
		Jogo j = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(j.getId()).toUri();
		return ResponseEntity.created(null).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<JogoDTO> update(@PathVariable Integer id, @Valid @RequestBody JogoDTO objDTO){
		Jogo j = service.update(id, objDTO);
		return ResponseEntity.ok().body(new JogoDTO(j));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<JogoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
