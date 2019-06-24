package controller;

import model.*;
import view.*;

import java.util.*;

public class UsuarioControlador{

    ManipulacaoArquivo ma = ManipulacaoArquivo.getInstancia();
    ArrayList<Usuario> usuarios = ma.lista;

    public void logar(String nome, String login, String senha){
        if(usuarios.contains(new Paciente(nome, login, senha))){
            
        }
    }

}