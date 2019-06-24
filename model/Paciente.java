package model;

import view.*;
import controller.*;

public class Paciente extends Usuario{

	public Paciente(String login, String senha){
		super(login, senha);
	}

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

