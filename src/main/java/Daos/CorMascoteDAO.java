package Daos;

import Daos.JDBC.Conexao;
import Model.CorMascote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CorMascoteDAO {
    private Connection conn; // Conexão com o banco de dados
    private PreparedStatement pstmt;
    private ResultSet rs; // Para armazenar os resultados de consultas SQL
    Conexao conexao = new Conexao(); // Instância da classe de conexão com o banco

    // Método para cadastrar uma nova cor de mascote no banco de dados
    public boolean cadastrarCorMascote(CorMascote corMascote){
        try{
            // Abrindo conexão com o banco
            conexao.conectar();
            // Comando SQL para inserir uma nova cor de mascote
            PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "INSERT INTO tb_cor_mascote (text_fundo, text_primaria, text_secundaria, createdAt) " +
                            "VALUES(?,?,?,current_date)"
            );
            // Setando os parâmetros para a inserção no banco de dados
            pstmt.setString(1, corMascote.getTextoFundo());
            pstmt.setString(2, corMascote.getTextoPri());
            pstmt.setString(3, corMascote.getTextoSec());
            // Executando o comando SQL no banco e retornando true em caso de sucesso
            pstmt.execute();
            return true;
        }
        // Tratando exceção SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false; // Retorna false em caso de falha
        }
        // Fechando a conexão com o banco de dados
        finally {
            conexao.desconectar(); // Garante que a conexão será fechada
        }
    }

    // Método para selecionar cores de mascote que não foram "deletadas"
    public ResultSet selecionarCorMascoteA(){
        try{
            // Abrindo conexão com o banco
            conexao.conectar();
            // Comando SQL para selecionar cores não deletadas
            pstmt = conexao.getConn().prepareStatement("select * from tb_cor_mascote where deletedat is null ");
            // Executando o comando e guardando o resultset
            rs = pstmt.executeQuery();
        }
        // Tratando exceção do banco e voltando null
        catch (SQLException sqle){
            return null; // Retorna null em caso de erro
        }
        // Fechando conexão com banco de dados
        finally {
            conexao.desconectar(); // Garante que a conexão será fechada
        }
        return rs; // Retorna o resultset contendo os dados
    }

    // Método para selecionar cores de mascote que foram "deletadas"
    public ResultSet selecionarCorMascoteI(){
        try{
            // Abrindo conexão com o banco
            conexao.conectar();
            // Comando SQL para selecionar cores deletadas
            pstmt = conexao.getConn().prepareStatement("select * from tb_cor_mascote where deletedat is not null ");
            // Executando o comando e guardando o resultset
            rs = pstmt.executeQuery();
        }
        // Tratando exceção do banco e voltando null
        catch (SQLException sqle){
            return null; // Retorna null em caso de erro
        }
        // Fechando conexão com banco de dados
        finally {
            conexao.desconectar(); // Garante que a conexão será fechada
        }
        return rs; // Retorna o resultset contendo os dados
    }

    // Método para realizar a "exclusão" de uma cor de mascote
    public boolean softDeleteCorMascote(int idCorMascote) {
        try {
            // Conectando ao banco de dados
            conexao.conectar();
            // Comando SQL para atualizar o campo deletedAt
            PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_cor_mascote SET deletedat = current_date, updateat = current_date WHERE pk_int_id_cor_mascote = ?"
            );

            // Setando os parâmetros
            pstmt.setInt(1, idCorMascote);
            // Executando o comando SQL e retornando o resultado da verificação
            return pstmt.executeUpdate() > 0; // Retorna true se a atualização afetou alguma linha
        } catch (SQLException sqles) {
            sqles.printStackTrace();
            return false; // Retorna false em caso de falha
        } finally {
            // Fechando a conexão com o banco de dados
            conexao.desconectar(); // Garante que a conexão será fechada
        }
    }

    // Método para atualizar uma cor de mascote
    public boolean atualizarCorMascote(String nomeCampo, String atualizacaoCampo, int pkCorMascote) {
        // Lista de campos válidos para evitar SQL injection
        if (!nomeCampo.equals("text_fundo") && !nomeCampo.equals("text_primaria") && !nomeCampo.equals("text_secundaria")) {
            System.out.println("Campo inválido: " + nomeCampo);
            return false; // Retorna false se o campo não é válido
        }

        try {
            // Conectar ao banco de dados
            conexao.conectar();
            // Criar consulta SQL com o nome do campo diretamente na string (já validado)
            pstmt = conexao.getConn().prepareStatement("UPDATE tb_cor_mascote SET " + nomeCampo + " = ?, updateat = current_date WHERE pk_int_id_cor_mascote = ?");

            // Definir os parâmetros
            pstmt.setString(1, atualizacaoCampo);
            pstmt.setInt(2, pkCorMascote);

            // Executar atualização e retornar o sucesso da operação
            return pstmt.executeUpdate() > 0; // Retorna true se a atualização afetou alguma linha
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false em caso de falha
        } finally {
            // Fechar conexão com o banco de dados
            conexao.desconectar(); // Garante que a conexão será fechada
        }
    }





}
