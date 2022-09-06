package com.funtech.jogoszerados.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtech.jogoszerados.domain.Player;
import com.funtech.jogoszerados.domain.dtos.PlayerDTO;
import com.funtech.jogoszerados.repositories.PlayerRepository;
import com.funtech.jogoszerados.services.exceptions.DataIntegrityViolationException;
import com.funtech.jogoszerados.services.exceptions.ObjectNotFoundException;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;

	public Player findById(Integer id) {
		Optional<Player> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Jogador não encontrado! ID: " + id));
	}

	public List<Player> findAll() {
		return repository.findAll();
	}

	public Player create(PlayerDTO objDTO) {
		checkEmail(objDTO);
		objDTO.setId(null);

		Player p = new Player(objDTO);
		return repository.save(p);
	}

	public Player delete(Integer id) {
		Player p = repository.getOne(id);
		p.setIsActive(false);
		return repository.save(p);
	}

	public Player update(Integer id, @Valid PlayerDTO objDTO) {
		objDTO.setId(id);
		objDTO.setIsActive(true); // Linha para que se mantenha o atributo isActive como true. Não pode ser null
		Player p = findById(id);
		checkEmail(objDTO);
		p = new Player(objDTO);
		return repository.save(p);
	}

	private void checkEmail(PlayerDTO objDTO) {
		Optional<Player> obj = repository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema");
		}
	}
}
