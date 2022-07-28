package br.com.radixeng.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.radixeng.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	Curso findByNome(String nomeCurso);

	Curso findFirstByNome(String nomeCurso);
}
