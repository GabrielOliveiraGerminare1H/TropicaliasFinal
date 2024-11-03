package Daos;

import Daos.JDBC.Conexao;
import Model.Barraca;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarracaDAO {
    // Variáveis de conexão e manipulação de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para cadastrar uma nova barraca no banco de dados
    public boolean cadastrarBarraca(Barraca barraca) {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();
            // Comando SQL para inserção de uma nova barraca
            pstmt = conexao.getConn().prepareStatement(
                    "INSERT INTO tb_barraca (var_nome, fk_int_id_evento, createdat) VALUES (?, ?, current_date)"
            );
            // Definindo os parâmetros para inserção
            pstmt.setString(1, barraca.getNome());
            pstmt.setInt(2, barraca.getFk_int_id_evento());
            // Executa o comando SQL; retorna true se bem-sucedido, false se falha na exceção
            pstmt.execute();
            return true;
        } catch (SQLException sqles) {
            // Tratamento da exceção SQL em caso de erro
            sqles.printStackTrace();
            return false;
        } finally {
            // Fechando conexão com o banco de dados
            conexao.desconectar();
        }
    }

    // Método para selecionar barracas ativas (onde "deletedat" é nulo)
    public ResultSet selecionarBarracaA() {
        try {
            // Abrindo conexão com o banco
            conexao.conectar();
            // Consulta SQL para barracas ativas
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca WHERE deletedat IS NULL");
            // Executa a consulta e armazena o resultado no ResultSet
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            // Retorna null em caso de falha na consulta
            return null;
        } finally {
            // Fecha a conexão
            conexao.desconectar();
        }
        return rs;
    }

    // Método para selecionar barracas inativas (onde "deletedat" não é nulo)
    public ResultSet selecionarBarracaI() {
        try {
            // Abrindo conexão com o banco
            conexao.conectar();
            // Consulta SQL para barracas inativas
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca WHERE deletedat IS NOT NULL");
            // Executa a consulta e armazena o resultado no ResultSet
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            // Retorna null em caso de falha na consulta
            return null;
        } finally {
            // Fecha a conexão
            conexao.desconectar();
        }
        return rs;
    }

    // Método para realizar o soft delete de uma barraca (define o campo "deletedat" com a data atual)
    public boolean softDeleteBarraca(int idBarraca) {
        try {
            // Conectando ao banco de dados
            conexao.conectar();
            // Comando SQL para atualizar o campo deletedAt e updateAt
            PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_barraca SET deletedat = current_date, updateat = current_date WHERE pk_int_id_barraca = ?"
            );
            // Definindo o ID da barraca que será excluída
            pstmt.setInt(1, idBarraca);
            // Executa a atualização e retorna true se ao menos uma linha foi afetada
            return pstmt.executeUpdate() > 0;
        } catch (SQLException sqle) {
            // Exibe o stack trace para depuração e retorna false em caso de erro
            sqle.printStackTrace();
            return false;
        } finally {
            // Fechando a conexão com o banco de dados
            conexao.desconectar();
        }
    }

    // Método para atualizar um campo específico de uma barraca
    public boolean atualizarBarraca(String nomeCampo, String valorNovo, int pkCampo) {
        try {
            // Conectando ao banco de dados
            conexao.conectar();
            // Comando SQL para atualizar um campo específico, passando o nome do campo como parâmetro
            pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_barraca SET " + nomeCampo + " = ?, updateat = current_date WHERE pk_int_id_barraca = ?"
            );
            // Definindo os parâmetros da atualização
            pstmt.setString(1, valorNovo); // Novo valor para o campo
            pstmt.setInt(2, pkCampo);      // ID da barraca que será atualizada
            // Executa a atualização e retorna true se pelo menos uma linha foi afetada
            return pstmt.executeUpdate() > 0;
        } catch (SQLException sqle) {
            // Exibe o stack trace para depuração e retorna false em caso de erro
            sqle.printStackTrace();
            return false;
        } finally {
            // Fecha a conexão com o banco de dados
            conexao.desconectar();
        }
    }
}
