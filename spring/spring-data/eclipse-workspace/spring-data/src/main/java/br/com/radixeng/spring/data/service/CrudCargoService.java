package br.com.radixeng.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.radixeng.spring.data.orm.Cargo;
import br.com.radixeng.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private final CargoRepository cargoRepository;
	
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Secao de cargos");
			System.out.println("Qual acao voce deseja executar?");
			System.out.println("0 - Sair da secao");
			System.out.println("1 - Criar");
			System.out.println("2 - Ler");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Remover");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
				
			case 2:
				visualizar();
				break;
				
			case 3:
				atualizar(scanner);
				break;
				
			case 4: 
				remover(scanner);
				break;
				
			default:
				system = false;
				break;
			}
		}
		
	}

	private void remover(Scanner scanner) {
		System.out.println("Insira o ID do cargo:");
		cargoRepository.deleteById(scanner.nextInt());
		System.out.println("Removido.");
	}

	private void salvar(Scanner scanner) {
		Cargo cargo = new Cargo();
		System.out.println("Descricao do cargo:");
		cargo.setDescricao(scanner.next());
		cargoRepository.save(cargo);
		System.out.println("Salvo.");
	}
	

	private void atualizar(Scanner scanner) {
		Cargo cargo = new Cargo();
		System.out.println("Insira o ID do cargo:");
		cargo.setId(scanner.nextInt());
		
		System.out.println("Descricao do cargo:");
		cargo.setDescricao(scanner.next());
		
		cargoRepository.save(cargo);
		System.out.println("Atualizado.");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(System.out::println);
	}
	
	
	
}
