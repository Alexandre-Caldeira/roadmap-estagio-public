package br.com.radixeng.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "unidadesdetrabalho")
public class UnidadeTrabalho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	protected String endereco;
	
	@ManyToMany
	protected List<Funcionario> funcionarios;
	
	@Override
	public String toString() {
		return "Unidade [id="+id+", descricao="+descricao+", endereco="+endereco+"]";
	}
}
