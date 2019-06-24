package model;

import view.*;
import controller.*;

public class Atendente extends Usuario{
  
	public Atendente(String nome, String login, String senha){
		super(nome, login, senha);
	}

	public boolean logar(String login, String senha) throws Exception{
		if(this.getLogin().equalsIgnoreCase(login) && this.senha.equals(senha)){
			try{
				TelaAtendente tAtd = new TelaAtendente();
				return true;
			}catch(Exception e){
				throw new Exception();
			}
		}
		return false;
	}
    
}