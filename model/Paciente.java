package model;

class Paciente extends Usuario{
  protected String login;
  protected String senha;
  
  public Paciente(String login, String senha){
    super(login, senha);
  }
  
}
