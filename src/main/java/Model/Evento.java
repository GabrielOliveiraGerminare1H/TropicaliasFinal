package Model;

import java.time.LocalDate;

public class Evento {
    // Atributos da classe Evento

    private LocalDate dtInicio;         // Data de início do evento
    private LocalDate dtFinal;          // Data de término do evento
    private String nome;                 // Nome do evento
    private String local;                // Local onde o evento será realizado
    private double precoTicket;          // Preço do ticket para o evento
    private int fkUsuario;       // Chave estrangeira para o usuário criador do evento

    // Construtor da classe
    public Evento(LocalDate dtInicio, LocalDate dtFinal, String nome, String local, double precoTicket, int fkUsuario) {
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.nome = nome;
        this.local = local;
        this.precoTicket = precoTicket;
        this.fkUsuario = fkUsuario;
    }

    // Métodos getters e setters para acessar e modificar os atributos

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getPrecoTicket() {
        return precoTicket;
    }

    public void setPrecoTicket(double precoTicket) {
        this.precoTicket = precoTicket;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    // Método toString para representar o objeto Evento
    @Override
    public String toString() {
        return "--EVENTO" +
                "--Nome: " + this.nome +
                "\n--Local: " + this.local +
                "\n--Preço do ticket: " + this.precoTicket +
                "\n--Foreign key do usuário: " + this.fkUsuario +
                "\n--Data de início: " + this.dtInicio +
                "\n--Data de término: " + this.dtFinal;
    }
}
