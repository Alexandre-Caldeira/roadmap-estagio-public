package br.com.radixeng.forum.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respostas")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode 
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	
	@ManyToOne
	private Topico topico;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@ManyToOne
	private Usuario autor;
	
	private Boolean solucao = false;
}
