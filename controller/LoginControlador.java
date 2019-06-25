package controller;

import model.*;

import java.util.*;

public class LoginControlador{
    String login;
    String senha;

    ManipulacaoArquivo dados = ManipulacaoArquivo.getInstancia();
    ArrayList<Usuario> usuarios = dados.lista;

    public LoginControlador(String login, String senha){
        setLoginSenha(login, senha);
    }

    public boolean logar(){
        try{
            Admin adm = new Admin();
            if(adm.logar(this.login, this.senha)){
                return true;
            }
            for(Usuario c : usuarios){
                if(c.getLogin().equalsIgnoreCase(this.login)){
                    return c.logar(this.login, this.senha);
                }
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public void setLoginSenha(String login,String senha){
        this.login = login;
        this.senha = senha;
    }

}