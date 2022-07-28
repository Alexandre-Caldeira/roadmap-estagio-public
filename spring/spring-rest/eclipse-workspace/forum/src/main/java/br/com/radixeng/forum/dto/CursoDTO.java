package br.com.radixeng.forum.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.radixeng.forum.modelo.Curso;
import lombok.Getter;

@Getter
public class CursoDTO {
	
	private Long id;
	private String nome;
	private String categoria;
	
	public CursoDTO(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.categoria = curso.getCategoria();
	}

	public static List<CursoDTO> converter(List<Curso> cursos) {
		return cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
	}
}
