package Model;

import java.sql.Date;

public class Usuario {
    // Atributos da classe Usuario
    private String textFoto;       // URL ou caminho da foto do usuário
    private String varEmail;       // Email do usuário
    private String senha;          // Senha do usuário
    private String userName;       // Nome de usuário
    private Date dtNascimento;     // Data de nascimento do usuário
    private String descricaoUsua;  // Descrição do perfil do usuário
    private Long cpf;              // CPF do usuário
    private String nome;           // Nome do usuário
    private int fkEndereco;// Chave estrangeira para o endereço do usuário
    private String varRole;        // Tipo de usuário

    // Método construtor da classe
    public Usuario(String textFoto, String varEmail, String senha, String userName,
                   Date dtNascimento, String descricaoUsua, Long cpf, String nome,
                   int fkEndereco, String varRole) {
        this.textFoto = textFoto;
        this.varEmail = varEmail;
        this.senha = senha;
        this.userName = userName;
        this.dtNascimento = dtNascimento;
        this.descricaoUsua = descricaoUsua;
        this.cpf = cpf;
        this.nome = nome;
        this.fkEndereco = fkEndereco;
        this.varRole = varRole;
    }

    // Métodos getters e setters para acessar e modificar os atributos

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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
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

    public int getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(int fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public String getVarRole() {
        return varRole;
    }

    public void setVarRole(String varRole) {
        this.varRole = varRole;
    }

    // Método toString para exibir as informações do usuário
    @Override
    public String toString() {
        return "USUÁRIO " +
                "\n--Texto Foto:" + textFoto + "\n--Email:" + varEmail + "\n--Senha:" + senha +
                "\n--UserName:" + userName  + "\n--Data Nascimento:" + dtNascimento +
                "\n--Descrição do Usuário:" + descricaoUsua  + "\n--CPF:" + cpf +
                "\n--Nome:" + nome + "\n--Foreign key do endereço do usuário:" + fkEndereco +
                "\n--varRole:" + varRole;
    }
}
