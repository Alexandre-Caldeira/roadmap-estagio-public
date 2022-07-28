package br.com.radixeng.viewmodel;

import java.lang.reflect.Field;

public class EnderecoView implements IJson {
	// Address AddressLine1 , Address AddressLine2
	// StateProvince Name, AddressLine1 CountryRegionCode

	private String Linha1;
	private String Linha2;
	private String Estado;
	private String Pais;
	private String Tipo; // Cobranca? Entrega? Favorito?

	public EnderecoView(String linha1, String linha2, String estado, String pais, String tipo) {
		Linha1 = linha1;
		Linha2 = linha2;
		Estado = estado;
		Pais = pais;
		Tipo = tipo;
	}

	public String toJSON() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		// determine fields declared in this class only (no fields of superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names paired with their values
		for (Field field : fields) {
			result.append("\t");
			try {
				result.append(field.getName());
				result.append(": ");
				// requires access to private field:
				result.append(field.get(this));
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

	public String getLinha1() {
		return Linha1;
	}

	public void setLinha1(String linha1) {
		Linha1 = linha1;
	}

	public String getLinha2() {
		return Linha2;
	}

	public void setLinha2(String linha2) {
		Linha2 = linha2;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}
