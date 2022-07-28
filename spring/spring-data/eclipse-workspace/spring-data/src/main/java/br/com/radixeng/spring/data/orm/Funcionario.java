package br.com.radixeng.spring.data.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	@Column(columnDefinition = "varchar(11)", nullable = false)
	protected String cpf;
	protected Double salario;
	@Column(name = "data_de_contratacao")
	protected LocalDate dataContratacao;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	protected Cargo cargo;
	
	@ManyToMany
	@JoinTable(name = "funcionario_trabalha_em", 
			  joinColumns = @JoinColumn(name = "funcionarios_id"), 
			  inverseJoinColumns = @JoinColumn(name = "unidadesdetrabalho_id"))
	protected List<UnidadeTrabalho> unidadesTrabalho;
	
	@Override
	public String toString() {
		return "Cargo [id="+id+", nome="+nome+", cpf"+cpf+", salario"+salario+", date="+dataContratacao+"]";
	}
}
