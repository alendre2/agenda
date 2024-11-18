package entity;

public class Contato {
	
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	private Data dataAnivesario;
	
	
	public Contato(String nome, String telefone, String celular, String email, Data dataAnivesario) {
		this.nome = nome.substring(0,40);
		this.telefone = telefone.substring(0,15);
		this.celular = celular.substring(0,15);
		this.email = email.substring(0,40);
		this.dataAnivesario = dataAnivesario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Data getDataAnivesario() {
		return dataAnivesario;
	}

	public void setDataAnivesario(Data dataAnivesario) {
		this.dataAnivesario = dataAnivesario;
	}
	
	
	
	

}
