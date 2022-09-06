package com.funtech.jogoszerados.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtech.jogoszerados.domain.Jogo;
import com.funtech.jogoszerados.domain.Player;
import com.funtech.jogoszerados.domain.enums.Status;
import com.funtech.jogoszerados.repositories.JogoRepository;
import com.funtech.jogoszerados.repositories.PlayerRepository;

@Service
public class DBService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private JogoRepository jogoRepository;

	public void instanciaDB() {

		Player player = new Player(null, "Rafael", "rafael@rafael.com", "123");
		Player player2 = new Player(null, "Andressa", "andressa@andressa.com", "321");
		Player player3 = new Player(null, "Miguel", "miguel@miguel.com", "213");

		Jogo jogo = new Jogo(null, "Crash Bandicoot 3", "PSX", Status.PLATINADO, null, player);
		Jogo jogo2 = new Jogo(null, "Crash Bandicoot 2", "PSX", Status.TERMINADO, null, player2);
		Jogo jogo3 = new Jogo(null, "Crash Bandicoot 1", "PSX", Status.PLATINADO, null, player3);
		Jogo j = new Jogo(null, "Syphon Filter", "PSX", Status.TERMINADO, null, player);
		Jogo j2 = new Jogo(null, "Tekken", "PSX", Status.TERMINADO, null, player);
		Jogo j3 = new Jogo(null, "Driver 2", "PSX", Status.PLATINADO, null, player);

		playerRepository.saveAll(Arrays.asList(player, player2, player3));
		jogoRepository.saveAll(Arrays.asList(jogo, jogo2, jogo3, j, j2, j3));

	}
}
