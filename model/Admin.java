package model;

import view.*;
import controller.*;

public class Admin extends Atendente{
   
    public Admin(){
        super("admin", "admin");
    }

    public boolean logar(String login, String senha) throws Exception{
		if(this.getLogin().equalsIgnoreCase(login) && this.senha.equals(senha)){
            try{
    			TelaAdmin tAdm = new TelaAdmin();
	    		return true;
            }catch(Exception e){
                throw new Exception();
            }
		}
		return false;
	}

}