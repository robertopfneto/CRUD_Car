package br.edu.ifms.Carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Carros.modelo.Carros;

public interface CarrosRepository  extends JpaRepository <Carros, Long>  {
}
