package Model;

import java.sql.Date;

public class Evento {
    private String nome;
    private String local;
    private double precoTicket;
    private int fk_int_id_usuario;

    private Date dt_inicio;
    private Date dt_final;

    public Evento(String nome, String local, double precoTicket, int fk_int_id_usuario, Date dt_inicio, Date dt_final){
        this.nome = nome;
        this.local = local;
        this.precoTicket = precoTicket;
        this.fk_int_id_usuario = fk_int_id_usuario;
        this.dt_inicio=dt_inicio;
        this.dt_final=dt_final;
    }

    public String getNome(){
        return this.nome;
    }

    public String getLocal(){
        return this.local;
    }

    public double getPrecoTicket(){
        return this.precoTicket;
    }

    public int getFk_int_id_usuario(){
        return this.fk_int_id_usuario;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public Date getDt_final() {
        return dt_final;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setLocal(String novoLocal){
        this.local = novoLocal;
    }

    public void setPrecoTicket(double novoPrecoTicket){
        this.precoTicket = novoPrecoTicket;
    }

    public void setTextoSec(int novoFk_int_id_usuario){
        this.fk_int_id_usuario = novoFk_int_id_usuario;
    }

    public String toString(){
        return "-->Nome: " + this.nome + "\n-->Local: "+ this.local +"\n-->Preço do ticket: "+ this.precoTicket +
                "\n-->Foreign key do usuário: "+ this.fk_int_id_usuario;
    }
}

