package model;

class Medico extends Usuario{
    protected String login;
    protected String senha;

    public Medico(String login, String senha){
        super(login, senha);
    }
}