package java.model;

import java.io.Serializable;

public class PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DESCRIÇÃO_PADRAO = "Nova pessoa";
    public static final int MAX_PESSOA = 1000;
    private int id;
    private String nome;
    private String email;
    private String login;

    public void Pessoa() {
        id = -1;
        nome = DESCRIÇÃO_PADRAO;
        email = DESCRIÇÃO_PADRAO;
        login = DESCRIÇÃO_PADRAO;
    }

    public void Pessoa(int id, String nome, String email, String login){
        setId(id);
        setNome(nome);
        setEmail(email);
        setLogin(login);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String toString(){
        return "Nome = " + nome + "Email = " + email + "Login = " + login;
    }

    public boolean equals(Object obj){
        return (this.getId() == ((PessoaModel)obj).getId());
    }
}
