package desafio1;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

// Referencia de GUI:
// https://mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
// TODO: refatorar para nao implementar Escritor

public class GerenteConsole extends Analista implements Escritor {
	// Controla modo de interfacear com usuario.
	// modoDisplay tem 2 digitos:
	// 1o digito			2o digito
	// 	0: console			 0: original	
	//	1: visual			 1: via Array
	private int modoDisplay;
	
	public GerenteConsole(SessaoUI sessao) {
		super(sessao);
		System.out.println("Gerente de console adcionado para "+ sessao.nomeDaSessao + " #"+sessao.idSessao+".");
	}

//	@Override
	public boolean salvaResultado(String nomeDoArquivo) {
		this.mostraDados();
		return true;
	}
	
	public void setModoDisplay(int modoDisplay) {
		this.modoDisplay = modoDisplay;	// nao exige getter	!
	}
	
	public boolean receberDados() {
		int contaTentativas = 0;	// flag de limite de tentativas
		
		while (contaTentativas <3) {
			if(this.modoDisplay <= 01) {
				// console original
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("\nDigite "+registro.getDadosInformados().length+" numeros: ");
				for (int i=0; i<registro.getDadosInformados().length; i++) { 					
					int novoNum = scanner.nextInt();
					if(registro.setDado(i, novoNum) == false) {
						contaTentativas++;
						i--;
						System.out.println("Restam "+(3-contaTentativas)+" tentativas.");
						System.out.print("\nDigite "+registro.getDadosInformados().length+" numeros: ");
					}
					if (contaTentativas>=3) {
						break;
					}
				}
				contaTentativas = 99; // quebra while
				scanner.close();
				this.mostraDados();
										
			}else { 
				// insere via GUI
				int novoNum; 
				for (int i=0; i<registro.getDadosInformados().length; i++) { 
					String m = JOptionPane.showInputDialog("Digite um numero inteiro de 0 a 10:");
					System.out.println(i);
					try {
						novoNum = Integer.parseInt(m); // TODO: tratar entradas invalidas.
						if(registro.setDado(i, novoNum) == false) {
							// JOptionPane.showMessageDialog(null,"Valor invalido. Reinicie.");
							contaTentativas++;
							JOptionPane.showMessageDialog(null,"Valor invalido. Restam "+(3-contaTentativas)+" tentativas.");
							i--;
						}
						if (contaTentativas>=3) {
							break;
						}
					}catch(java.lang.NumberFormatException e){
						System.out.println("Numero nao informado. Interrompendo processo.");
						System.out.println(e);
						contaTentativas=5;
						break;
					}				
				}
				contaTentativas = 99;
		        
			}
			
			
		}
		
		if(contaTentativas == 99) {
			// Todos inseridos com sucesso.
			return true;
		}else {
			// Ocorreu algum erro (ja mostrado).
			return false;
		}
	}
	

	public void mostraDados() {
		switch(this.modoDisplay) {
			case 00: // console original

				for(int c = 0; c < registro.getDadosInformados().length; c++)
					System.out.print(registro.getDadosInformados()[c]+" ");
				
				System.out.println(this.calculaMedia());
				
				break;
				
			case 01: // console 2.0
				System.out.println(Arrays.toString(registro.getDadosInformados())+"=> Media = "+this.getMedia());
				break;
				
			case 10: // visual original
				JOptionPane.showMessageDialog(null,Arrays.toString(registro.getDadosInformados())+"=> Media = "+this.getMedia());
				break;
				
			case 11: // visual 2.0
				JOptionPane.showMessageDialog(null,"Novo visual ainda em desenvolvimento, apresentando antigo.");
				JOptionPane.showMessageDialog(null,Arrays.toString(registro.getDadosInformados())+"=> Media = "+this.getMedia());
				break;
		}
	}
	
	

}
