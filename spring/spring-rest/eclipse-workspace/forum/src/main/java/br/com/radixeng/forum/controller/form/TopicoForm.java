package br.com.radixeng.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.radixeng.forum.modelo.Topico;
import br.com.radixeng.forum.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class TopicoForm {
	
	@NotNull @NotEmpty @Length(max = 70)
	private String titulo;
	
	@NotNull @NotEmpty @Length(max = 140)
	private String mensagem;
	
	@NotNull @NotEmpty @Length(max = 35)
	private String nomeCurso;
	
	public Topico converter(CursoRepository cursoRepository) {
		return new Topico(this.titulo, this.mensagem, cursoRepository.findFirstByNome(this.nomeCurso));
	}
	
	
}
