package model;

class Paciente extends Usuario{

	public Paciente(String login, String senha){
		super(login, senha);
	}

	public void logar(String login, String senha){
		if(this.getLogin().equalsIgnoreCase(login) && this.senha.equals(senha)){
			TelaUsuario tusr = new TelaUsuario();
		}
	}

}

