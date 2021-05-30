package java.model;

import java.io.Serializable;

public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DESCRIÇÃO_PADRAO = "Novo usuario";
    public static final int MAX_USUARIO = 1000;
    private String login;
    private String senha;


    public void Usuario() {
        login = DESCRIÇÃO_PADRAO;
        senha = DESCRIÇÃO_PADRAO;
    }

    public void Usuario(String login, String senha){
        setLogin(login);
        setLogin(login);
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String toString(){
        return "Login = " + login + "Senha = " + senha;
    }

    public boolean equals(Object obj){
        return (this.getLogin() == ((UsuarioModel)obj).getLogin());
    }
}

