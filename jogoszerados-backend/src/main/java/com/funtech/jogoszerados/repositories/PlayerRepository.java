package com.funtech.jogoszerados.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtech.jogoszerados.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	Optional<Player> findByEmail(String email);
}
