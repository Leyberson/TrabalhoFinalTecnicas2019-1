package model;

class Atendente extends Usuario{
    protected String login;
    protected String senha;

    public Atendente(String login, String senha){
        super(login, senha);
    }

}