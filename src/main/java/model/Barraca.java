package model;

public class Barraca {
    // Atributos da classe
    private String nome;                // Nome da barraca
    private int fkEvento;       // Chave estrangeira que referencia o evento ao qual a barraca pertence

    // Construtor da classe Barraca
    public Barraca(String nome, int fkEvento) {
        this.nome = nome;
        this.fkEvento = fkEvento;
    }

    // Métodos getters e setters para acessar e modificar os atributos


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFkEvento() {
        return fkEvento;
    }

    public void setFkEvento(int fkEvento) {
        this.fkEvento = fkEvento;
    }

    // Método toString para representar o objeto Barraca
    @Override
    public String toString() {
        return "--Nome: " + this.nome +
                "\n--Foreign Key do evento: " + this.fkEvento;
    }
}
