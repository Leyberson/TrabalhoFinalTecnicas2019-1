package model;

import view.*;
import controller.*;

public class Medico extends Usuario{

	public Medico(String nome, String login, String senha){
		super(nome, login, senha);
	}

	//devido a falta de tela de medico isso sera alterado depois
	public boolean logar(String login, String senha) throws Exception{
		if(this.getLogin().equalsIgnoreCase(login) && this.senha.equals(senha)){
			try{
				TelaUsuario tUsr = new TelaUsuario();
				return true;
			}catch(Exception e){
				throw new Exception();
			}
		}
		return false;
	}

}