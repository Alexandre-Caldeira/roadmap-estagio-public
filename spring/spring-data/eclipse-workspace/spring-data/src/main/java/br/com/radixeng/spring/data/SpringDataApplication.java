package br.com.radixeng.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.radixeng.spring.data.service.CrudCargoService;
import br.com.radixeng.spring.data.service.CrudFuncionarioService;
import br.com.radixeng.spring.data.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private final CrudCargoService crudCargoService;
	
	private final CrudFuncionarioService crudFuncionarioService;
	
	private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
		
	private Boolean system = true;
	
	public SpringDataApplication(
			CrudCargoService crudCargoService,
			CrudFuncionarioService crudFuncionarioService,
			CrudUnidadeTrabalhoService crudUnidadeTrabalhoService) {
		
		this.crudCargoService = crudCargoService;
		this.crudFuncionarioService = crudFuncionarioService;
		this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (system) {
			System.out.println("Qual acao voce deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Analisar Cargos");
			System.out.println("2 - Analisar Funcionarios");
			System.out.println("3 - Analisar Unidades de Trabalho");			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				crudCargoService.inicial(scanner);
				break;
				
			case 2:
				crudFuncionarioService.inicial(scanner);
				break;
				
			case 3:
				crudUnidadeTrabalhoService.inicial(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
		
		
		
	}

}