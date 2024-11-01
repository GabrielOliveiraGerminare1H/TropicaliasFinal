package Model;

import java.sql.Date;

public class Usuario {
    private String textFoto;
    private String varEmail;
    private String senha;
    private String userName;
    private Date dt_nascimento;
    private String descricaoUsua;
    private Long cpf;
    private String nome;
    private int Fk_int_id_endereco;

    private String varying;

    public Usuario(String textFoto, String varEmail, String senha, String userName,
                       Date dt_nascimento, String descricaoUsua, Long cpf, String nome,
                       int fk_int_id_endereco,String varying) {
            this.textFoto = textFoto;
            this.varEmail = varEmail;
            this.senha = senha;
            this.userName = userName;
            this.dt_nascimento = dt_nascimento;
            this.descricaoUsua = descricaoUsua;
            this.cpf = cpf;
            this.nome = nome;
            this.Fk_int_id_endereco = fk_int_id_endereco;
            this.varying = varying;
        }

    public String getTextFoto() {
        return textFoto;
    }

    public void setTextFoto(String textFoto) {
        this.textFoto = textFoto;
    }

    public String getVarEmail() {
        return varEmail;
    }

    public void setVarEmail(String varEmail) {
        this.varEmail = varEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public java.util.Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDescricaoUsua() {
        return descricaoUsua;
    }

    public void setDescricaoUsua(String descricaoUsua) {
        this.descricaoUsua = descricaoUsua;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFk_int_id_endereco() {
        return Fk_int_id_endereco;
    }

    public void setFk_int_id_endereco(int fk_int_id_endereco) {
        Fk_int_id_endereco = fk_int_id_endereco;
    }

    public String getVarying() {
        return varying;
    }

    public void setVarying(String varying) {
        this.varying = varying;
    }
}

