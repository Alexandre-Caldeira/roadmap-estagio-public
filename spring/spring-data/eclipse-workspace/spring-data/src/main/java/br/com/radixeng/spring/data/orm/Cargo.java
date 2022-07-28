package br.com.radixeng.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
@Table(name = "cargos")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	
	@OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
	protected List<Funcionario> funcionarios;
	
	@Override
	public String toString() {
		return "Cargo [id="+id+", descricao="+descricao+", funcionarios="+funcionarios+"]";
	}
}
