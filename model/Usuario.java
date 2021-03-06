package model;

import view.*;
import controller.*;

public abstract class Usuario implements java.io.Serializable{
    protected String login;
    protected String senha;
    protected String nome;

    public Usuario(String nome,String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    //Dois usuarios sao iguais se possuirem o mesmo login independente da formatacao
    public boolean equals(Usuario outra){
        return this.getLogin().equalsIgnoreCase(outra.getLogin());
    }
    
    public String toString(){
        return this.getLogin();
    }

    public abstract boolean logar(String login, String senha) throws Exception;

    public String getLogin(){
        return this.login;
    }

}