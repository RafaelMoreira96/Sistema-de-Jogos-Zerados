package com.funtech.jogoszerados.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.funtech.jogoszerados.domain.dtos.JogoDTO;
import com.funtech.jogoszerados.domain.enums.Status;

@Entity
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	// Variável do ID
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	// Variáveis referentes a atributos principais
	@NotNull(message = "O campo JOGO deve ser inserido")
	private String jogo;

	@NotNull(message = "O campo PLATAFORMA deve ser inserido")
	private String plataforma;

	@NotNull(message = "O campo STATUS deve ser inserido")
	private Status status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataTermino;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public Jogo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogo(Integer id, String jogo, String plataforma, Status status, LocalDate dataTermino, Player player) {
		super();
		this.id = id;
		this.jogo = jogo;
		this.plataforma = plataforma;
		this.status = status;
		this.dataTermino = LocalDate.now();
		this.player = player;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJogo() {
		return jogo;
	}

	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		return Objects.equals(id, other.id);
	}
}