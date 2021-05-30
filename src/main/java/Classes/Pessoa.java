package java.Classes;

import java.util.Random;

public class Pessoa {
    private int id;
	private String nome;
    private String email;
	private String login;
	Random geradorId = new Random();

	public Pessoa() {
        this.id = geradorId.nextInt(1000);//FUNÇÃO PARA FAZER O ID
        this.nome = "";
		this.email = "";
		this.login = "";
	}
	
	public Pessoa(String nome, String email, String login) {
        this.id = geradorId.nextInt(1000);;//FUNÇÃO PARA FAZER O ID
		this.nome = nome;
        this.email = email;
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId() {
	
    
        //AKI FUNCAO PARA FAZER ID
	
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", email=" + email +"]";
	}
	
}