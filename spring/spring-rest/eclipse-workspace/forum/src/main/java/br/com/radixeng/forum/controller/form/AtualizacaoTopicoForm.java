package br.com.radixeng.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.radixeng.forum.modelo.Topico;
import br.com.radixeng.forum.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AtualizacaoTopicoForm {
    
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    
    @NotNull @NotEmpty @Length(min = 5)
    private String mensagem;
    
    
    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
	Topico topico = topicoRepository.getById(id);
	
	topico.setTitulo(titulo);
	topico.setMensagem(mensagem);
	
	return topico;
    }
    
}

