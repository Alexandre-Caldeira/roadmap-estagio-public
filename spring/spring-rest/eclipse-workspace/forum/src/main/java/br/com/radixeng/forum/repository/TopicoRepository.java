package br.com.radixeng.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.radixeng.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	List<Topico> findByCurso_Nome(String nomeCurso);
		
	@Query("SELECT t FROM Topico t WHERE t.curso.categoria = :nomeCategoria")
	List<Topico> buscarPorCategoria(@Param("nomeCategoria") String nomeCategoria);
}
