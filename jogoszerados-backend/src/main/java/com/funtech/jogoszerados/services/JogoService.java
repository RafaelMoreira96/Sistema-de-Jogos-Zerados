package com.funtech.jogoszerados.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtech.jogoszerados.domain.Jogo;
import com.funtech.jogoszerados.domain.Player;
import com.funtech.jogoszerados.domain.dtos.JogoDTO;
import com.funtech.jogoszerados.repositories.JogoRepository;
import com.funtech.jogoszerados.services.exceptions.DataIntegrityViolationException;
import com.funtech.jogoszerados.services.exceptions.ObjectNotFoundException;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	@Autowired
	private PlayerService playerService;
 
	public Jogo findById(Integer id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Jogo não encontrado! ID: " + id));
	}

	public List<Jogo> findAll() {
		return repository.findAll();
	}

	public Jogo create(@Valid JogoDTO objDTO) {
		return repository.save(newJogo(objDTO));
	}

	public Jogo update(Integer id, @Valid JogoDTO obj) {
		obj.setId(id);

		Jogo j = findById(id);
		checkIds(obj);
		j = newJogo(obj);
		return repository.save(j);
	}

	private void checkIds(@Valid JogoDTO obj) {
		Optional<Jogo> j = repository.findById(obj.getId());

		if (j.isPresent() && j.get().getId() != obj.getId()) {
			throw new DataIntegrityViolationException("ID já cadastrado na sua relação!");
		}
	}

	private Jogo newJogo(JogoDTO obj) {
		Player p = playerService.findById(obj.getPlayer());

		Jogo j = new Jogo();

		if (j.getId() == null) {
			j.setId(obj.getId());
		}

		j.setPlayer(p);
		j.setJogo(obj.getJogo());
		j.setPlataforma(obj.getPlataforma());
		j.setStatus(obj.getStatus());
		j.setDataTermino(obj.getDataTermino());

		return j;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
