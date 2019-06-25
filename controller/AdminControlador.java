package controller;

import model.*;
import view.*;

import java.util.ArrayList;

public class AdminControlador extends AtendenteControlador{

	public boolean cadastrarFuncionario(String tipo, String nome, String login, String senha){
		for(Usuario c : usuarios){
			if(c.getLogin().equalsIgnoreCase(login)){
				return false;
			}
		}
		if(tipo.equals("Atendente")){
			usuarios.add(new Atendente(nome, login, senha));
			return true;
		}
		usuarios.add(new Medico(nome, login, senha));
		return true;
	}

	public boolean deletarFuncionario(String login){
        for(Usuario c : usuarios){
            if (c.equals(new Atendente("", login, "")) && ((c instanceof Atendente) || (c instanceof Medico))){
                usuarios.remove(c);
                dados.lista = usuarios;
                dados.escreverNoArquivo();
                return true;
            }
        }
        return false;
    }

}