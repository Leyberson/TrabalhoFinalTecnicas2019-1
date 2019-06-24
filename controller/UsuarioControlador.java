package controller;

import model.*;
import view.*;

public class UsuarioControlador{

    ArrayList<Usuario> usuarios;

    public void logar(String login, String senha){
        ManipulacaoArquivo dados = ManipulacaoArquivo.getInstance();
        usuarios = dados.lista;
        if(usuarios.contain(new Usuario(login, senha))){
            
        }
    }

}