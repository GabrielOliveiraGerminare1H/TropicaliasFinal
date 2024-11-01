package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Anuncio {
    private String notaFiscal;
    private LocalDate data;
    private double valor;
    private String varProduto;
    private int quantidade;
    private String statusVenda;
    private int fk_int_id_usuario;

    public Anuncio(String notaFiscal, LocalDate data, double valor, String varProduto, int quantidade, String statusVenda, int fk_int_id_usuario) {
        this.notaFiscal = notaFiscal;
        this.data = data;
        this.valor = valor;
        this.varProduto = varProduto;
        this.quantidade = quantidade;
        this.statusVenda = statusVenda;
        this.fk_int_id_usuario = fk_int_id_usuario;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getVarProduto() {
        return varProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public int getFk_int_id_usuario() {
        return fk_int_id_usuario;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setVarProduto(String varProduto) {
        this.varProduto = varProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public void setFk_int_id_usuario(int fk_int_id_usuario) {
        this.fk_int_id_usuario = fk_int_id_usuario;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "notaFiscal='" + notaFiscal + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                ", varProduto='" + varProduto + '\'' +
                ", quantidade=" + quantidade +
                ", statusVenda='" + statusVenda + '\'' +
                ", fk_int_id_usuario=" + fk_int_id_usuario +
                '}';
    }
}
