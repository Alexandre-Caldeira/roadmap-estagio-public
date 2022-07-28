package br.com.radixeng.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.radixeng.forum.modelo.StatusTopico;
import br.com.radixeng.forum.modelo.Topico;
import lombok.Getter;

@Getter
public class DetalhesTopicoDTO {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDTO> respostas;
	
	public DetalhesTopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		
		this.respostas = new ArrayList<RespostaDTO>();
		this.respostas.addAll(
				topico.getRespostas().stream()
					.map(RespostaDTO::new).collect(Collectors.toList()));
	}

}
