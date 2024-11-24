package entity;

public class Contato {
	
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	private Data dataAniversario;
	
	
	 public Contato(String nome, String telefone, String celular, String email, Data dataAnivesario) {
	        // Verifica o tamanho e corta a string se necessário
	        this.nome = (nome.length() > 40) ? nome.substring(0, 40) : nome;
	        this.telefone = (telefone.length() > 15) ? telefone.substring(0, 15) : telefone;
	        this.celular = (celular.length() > 15) ? celular.substring(0, 15) : celular;
	        this.email = (email.length() > 40) ? email.substring(0, 40) : email;
	        this.dataAniversario = dataAnivesario;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = (nome.length() > 40) ? nome.substring(0, 40) : nome;
	    }

	    public String getTelefone() {
	        return telefone;
	    }

	    public void setTelefone(String telefone) {
	        this.telefone = (telefone.length() > 15) ? telefone.substring(0, 15) : telefone;
	    }

	    public String getCelular() {
	        return celular;
	    }

	    public void setCelular(String celular) {
	        this.celular = (celular.length() > 15) ? celular.substring(0, 15) : celular;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = (email.length() > 40) ? email.substring(0, 40) : email;
	    }

	    public Data getDataAnivesario() {
	        return dataAniversario;
	    }

	    public void setDataAnivesario(Data dataAnivesario) {
	        this.dataAniversario = dataAnivesario;
	    }
	    
	    @Override
	    public String toString() {
	        return "Nome: " + nome + "\nTelefone: " + telefone + "\nCelular: " + celular + 
	               "\nEmail: " + email + "\nData de Aniversário: " + dataAniversario;
	    }
	}