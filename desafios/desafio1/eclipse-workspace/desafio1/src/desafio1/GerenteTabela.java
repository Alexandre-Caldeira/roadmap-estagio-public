package desafio1;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenteTabela extends Analista implements Escritor {

	public GerenteTabela(SessaoUI sessao) {
		super(sessao);
		System.out.println("Gerente de texto adcionado para "+ sessao.nomeDaSessao + " #"+sessao.idSessao+".");
	}

//	@Override
	public boolean salvaResultado(String nomeDoArquivo) {
		System.out.println("Salvando resultados para: "+this.getCaminhoPadrao()+nomeDoArquivo+".xlsx");

		String nomeFolha = "Resultados";

		try (XSSFWorkbook wb = new XSSFWorkbook()) {
			XSSFSheet sheet = wb.createSheet(nomeFolha) ;
			XSSFRow row = sheet.createRow(0);

			// Cria colunas e celulas para cada dado
			for (int c=0;c < registro.getDadosInformados().length; c++ ) {
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(registro.getDado(c));
				
				// TODO setar cell type para inteiro, facilitando trabalhos futuros
			}
			XSSFCell cell = row.createCell(registro.getDadosInformados().length);
			cell.setCellValue(this.calculaMedia()); // TODO: corrigir trailling zeros e usar this.getMedia()
			
			FileOutputStream fileOut = new FileOutputStream(this.getCaminhoPadrao()+nomeDoArquivo+".xlsx");
			
			wb.write(fileOut);
			
			fileOut.flush();
			fileOut.close();
			return true;
			
		} catch (IOException e){
			// Mostra erro de IO caso ocorra
			e.printStackTrace();
			return false;
		}
	}

}
