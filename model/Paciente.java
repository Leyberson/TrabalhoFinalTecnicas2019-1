package model;

import view.*;
import controller.*;

public class Paciente extends Usuario{

	public Paciente(String nome, String login, String senha){
		super(nome, login, senha);
	}

	public boolean logar(String login, String senha) throws Exception{
		if(this.getLogin().equalsIgnoreCase(login) && this.senha.equals(senha)){
			try{
				TelaUsuario tUsr = new TelaUsuario(this);
				return true;
			}catch(Exception e){
				throw new Exception();
			}
		}
		return false;
	}

}

