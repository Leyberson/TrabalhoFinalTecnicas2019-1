package model;

class Usuario implements java.io.Serializable{
    protected String login;
    protected String senha;

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    //Dois usuarios sao iguais se possuirem o mesmo login independente da formatacao
    public boolean equals(Usuario outra){
        return this.getLogin().equalsIgnoreCase(outra.getLogin());
    }

    public String getLogin(){
        return this.login;
    }

}