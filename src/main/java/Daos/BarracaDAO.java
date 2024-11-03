package Daos;

import Daos.JDBC.Conexao;
import Model.Barraca;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarracaDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public boolean cadastrarBarraca(Barraca barraca){
        try {
//            Abrindo conexão com o banco de dados
            conexao.conectar();
//            Comandos SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_barraca (var_nome, fk_int_id_evento,createdat) VALUES (?,?,current_date)");
//          Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setString(1, barraca.getNome());
            pstmt.setInt(2, barraca.getFk_int_id_evento());
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceção e irá retornar false
            pstmt.execute();
            return true;
        }
//        Tratando exceção SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }


    public ResultSet selecionarBarracaA(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca where deletedat is null ");

            //Executando o comando e guardando o resultset
            rs = pstmt.executeQuery();

        }catch (SQLException sqle){
            return null;
        }
        finally {
            conexao.desconectar();
        }
        return rs;
    }

    public ResultSet selecionarBarracaI(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca where deletedat is not null ");

            //Executando o comando e guardando o resultset
            rs = pstmt.executeQuery();

        }catch (SQLException sqle){
            return null;
        }
        finally {
            conexao.desconectar();
        }
        return rs;
    }


    public boolean softDeleteBarraca(int idBarraca) {
        try {
            // Conectando ao banco de dados
            conexao.conectar();
            // Comando SQL para atualizar o campo deletedAt
            PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_barraca SET deletedat = current_date, updateat = current_date WHERE pk_int_id_barraca = ?"
            );

            // Setando os parâmetros
            pstmt.setInt(1, idBarraca);
            // Executando o comando SQL e retornando o resultado da verificação
            return pstmt.executeUpdate() > 0; // Retorna true se a atualização afetou alguma linha
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false; // Retorna false em caso de falha
        } finally {
            // Fechando a conexão com o banco de dados
            conexao.desconectar(); // Garante que a conexão será fechada
        }
    }


    public boolean atualizarBarraca(String nomeCampo, String valorNovo, int pkCampo) {
        try {
            conexao.conectar(); // Abre a conexão com o banco
            pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_barraca SET " + nomeCampo + " = ?, updateat = current_date WHERE pk_int_id_barraca = ?"
            );
            pstmt.setString(1, valorNovo); // Define o novo valor para o campo
            pstmt.setInt(2, pkCampo); // Define o ID da barraca

            // Executa a atualização e retorna true se pelo menos uma linha for afetada
            return pstmt.executeUpdate() > 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Exibe o stack trace para depuração
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco
        }
    }

}

