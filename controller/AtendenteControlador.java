package controller;

import view.*;
import model.*;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class AtendenteControlador{
    ManipulacaoArquivo dados = ManipulacaoArquivo.getInstancia();
    public ArrayList<Usuario> usuarios = dados.lista;
    ArrayList<Consulta> consultas = dados.consultas;
    LocalDateTime agora;
    
    public ArrayList getPacientes(){
        ArrayList<String> pacientes = new ArrayList();
        for(Usuario c : usuarios){
            if(c instanceof Paciente){
                pacientes.add(c.getLogin());
            }
        }
        return pacientes;
    }
    
    public ArrayList getMedicos(){
        ArrayList<String> medicos = new ArrayList();
        for(Usuario c : usuarios){
            if(c instanceof Medico){
                medicos.add(c.getLogin());
            }
        }
        return medicos;
    }

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

    public boolean cadastrarConsultas(String pacienteLogin, String medicoLogin, int dia, int mes, int ano, int hora){
        if(dia>31 || dia <0 || mes > 12 || mes < 0 || hora < 0 || hora > 23){
            return false;
        }
        agora = LocalDateTime.now();
        LocalDateTime consultaHora = LocalDateTime.of(ano, mes, dia, hora, 0);
        if(agora.isAfter(consultaHora)){
            return false;
        }
        for(Consulta c : consultas){
            if(c.equals(new Consulta(new Paciente("", pacienteLogin, ""), new Medico("", medicoLogin, ""), dia, mes, ano, hora))){
                return false;
            }
        }
        for(Usuario a : usuarios){
            if(a.equals(new Paciente("", pacienteLogin,""))){
                for(Usuario c : usuarios){
                    if (c.equals(new Medico("", medicoLogin, ""))){
                        consultas.add(new Consulta((Paciente)a,(Medico) c, dia, mes, ano, hora));
                        dados.consultas = consultas;
                        dados.escreverNoArquivo();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}