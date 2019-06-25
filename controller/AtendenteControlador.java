package controller;

import view.*;
import model.*;

import java.util.*;

public class AtendenteControlador{
    ManipulacaoArquivo dados = ManipulacaoArquivo.getInstancia();
    ArrayList<Usuario> usuarios = dados.lista;

    public boolean cadastrarPaciente(String nome, String login, String senha){
        for(Usuario c : usuarios){
            if (c.equals(new Paciente(nome, login, senha))){return false;}
        }
        System.out.println("passa por aqui");
        usuarios.add(new Paciente(nome, login, senha));
        dados.lista = usuarios;
        dados.escreverNoArquivo();
        return true;
    }

    public ArrayList<Usuario> lerPaciente(){
        return this.usuarios;
    }

    public boolean deletarPaciente(String login){
        for(Usuario c : usuarios){
            if (c.equals(new Paciente("", login, "")) && (c instanceof Paciente)){
                usuarios.remove(c);
                dados.lista = usuarios;
                dados.escreverNoArquivo();
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarConsultas()
    
}