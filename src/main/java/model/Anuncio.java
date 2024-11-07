package model;

import java.time.LocalDate;

public class Anuncio {
    // Atributos da classe Anuncio
    private String notaFiscal;      // Nota fiscal associada ao anúncio
    private LocalDate data;         // Data de criação do anúncio
    private double valor;           // Valor do produto anunciado
    private String varProduto;      // Nome do produto
    private int quantidade;         // Quantidade do produto disponível para venda
    private String statusVenda;     // Status da venda ("disponível" ou "vendido")
    private int fkUsuario;  // Chave estrangeira para o usuário criador do anúncio

    // Construtor da classe
    public Anuncio(String notaFiscal, LocalDate data, double valor, String varProduto,
                   int quantidade, String statusVenda, int fkUsuario) {
        this.notaFiscal = notaFiscal;
        this.data = data;
        this.valor = valor;
        this.varProduto = varProduto;
        this.quantidade = quantidade;
        this.statusVenda = statusVenda;
        this.fkUsuario = fkUsuario;
    }

    // Métodos getters e setters para acessar e modificar os atributos

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVarProduto() {
        return varProduto;
    }

    public void setVarProduto(String varProduto) {
        this.varProduto = varProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    // Método toString para representar o objeto Anúncio
    @Override
    public String toString() {
        return "--ANÚNCIO" +
                "\n--Nota Fiscal:" + notaFiscal +
                "\n--Data:" + data +
                "\n--Valor:" + valor +
                "\n--Produto:" + varProduto +
                "\n--Quantidade:" + quantidade +
                "\n--Status venda:" + statusVenda +
                "\n--Foreign key do usuário:" + fkUsuario;
    }
}
