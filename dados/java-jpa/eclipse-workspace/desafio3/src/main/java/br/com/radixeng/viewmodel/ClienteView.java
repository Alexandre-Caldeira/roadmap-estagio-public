package br.com.radixeng.viewmodel;

import java.lang.reflect.Field;

public class ClienteView implements IJson {
	// Mr Fulano Ciclano
	// email

	private String Titulo;
	private String Nome;
	private String Sobrenome;
	private String Email;

	public ClienteView(String titulo, String nome, String sobrenome, String email) {
		Titulo = titulo;
		Nome = nome;
		Sobrenome = sobrenome;
		Email = email;
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

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
