package Daos;

import Daos.JDBC.Conexao;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    // Variáveis de conexão e manipulação de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para selecionar usuários ativos (onde "deletedat" é nulo)
    public ResultSet selecionarUsuarioA() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();
            // Comando SQL para selecionar usuários ativos
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_usuario WHERE deletedat IS NULL");
            // Executa a consulta e armazena o resultado no ResultSet
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            // Retorna null em caso de falha na consulta
            return null;
        } finally {
            // Fecha a conexão com o banco de dados
            conexao.desconectar();
        }
        // Retorna o conjunto de resultados com os dados dos usuários ativos
        return rs;
    }

    // Método para selecionar usuários inativos (onde "deletedat" não é nulo)
    public ResultSet selecionarUsuarioI() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();
            // Comando SQL para selecionar usuários inativos
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_usuario WHERE deletedat IS NOT NULL");
            // Executa a consulta e armazena o resultado no ResultSet
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            // Retorna null em caso de falha na consulta
            return null;
        } finally {
            // Fecha a conexão com o banco de dados
            conexao.desconectar();
        }
        // Retorna o conjunto de resultados com os dados dos usuários inativos
        return rs;
    }
}
