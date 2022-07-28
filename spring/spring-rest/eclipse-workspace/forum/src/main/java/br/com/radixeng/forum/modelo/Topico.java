package br.com.radixeng.forum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topicos")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode 
public class Topico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
		
	@ManyToOne
	private Usuario autor;
	
	@ManyToOne
	private Curso curso;
	
	@OneToMany(mappedBy = "topico") // la na classe resposta estara mapeado pelo atributo topico
	private List<Resposta> respostas = new ArrayList<>();
	
	
	public Topico(String titulo,String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}
}
