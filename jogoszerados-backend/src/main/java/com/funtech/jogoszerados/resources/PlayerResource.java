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

import com.funtech.jogoszerados.domain.Player;
import com.funtech.jogoszerados.domain.dtos.PlayerDTO;
import com.funtech.jogoszerados.services.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerResource {

	@Autowired
	private PlayerService service;

	// Função para pegar "jogador" por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> findById(@PathVariable Integer id) {
		Player obj = service.findById(id);
		return ResponseEntity.ok().body(new PlayerDTO(obj));
	}

	// Método para mostrar todos os jogadores
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> findAll() {
		List<Player> players = service.findAll();

		// A linha abaixo pega a lista de cima e passa pro objeto DTO para retornar esse
		// DTO para a resposta que ele tem que dar
		List<PlayerDTO> playersDTO = players.stream().map(obj -> new PlayerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(playersDTO);
	}

	// Método para criar um jogador no banco de dados
	@PostMapping
	public ResponseEntity<PlayerDTO> create(@Valid @RequestBody PlayerDTO objDTO) {
		Player p = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(null).build();
	}

	// Método para atualizar o jogador no banco de dados
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> update(@PathVariable Integer id, @Valid @RequestBody PlayerDTO objDTO) {
		Player p = service.update(id, objDTO);
		return ResponseEntity.ok().body(new PlayerDTO(p));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
