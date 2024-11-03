package Daos;

import Daos.JDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnuncioDAO {
    // Variáveis de conexão e manipulação de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para selecionar anúncios ativos (onde "deletedat" é nulo)
    public ResultSet selecionarAnuncioA() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();

            // Preparando a consulta SQL para selecionar anúncios ativos
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_anuncio WHERE deletedat IS NULL");

            // Executando o comando e armazenando o resultado no ResultSet
            rs = pstmt.executeQuery();

        } catch (SQLException sqle) {
            // Em caso de falha na consulta, retorna null
            return null;
        } finally {
            // Fecha a conexão com o banco de dados, garantindo liberação de recursos
            conexao.desconectar();
        }
        // Retorna o ResultSet contendo os anúncios ativos
        return rs;
    }

    // Método para selecionar anúncios inativos (onde "deletedat" não é nulo)
    public ResultSet selecionarAnuncioI() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();

            // Preparando a consulta SQL para selecionar anúncios inativos
            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_anuncio WHERE deletedat IS NOT NULL");

            // Executando o comando e armazenando o resultado no ResultSet
            rs = pstmt.executeQuery();

        } catch (SQLException sqle) {
            // Em caso de falha na consulta, retorna null
            return null;
        } finally {
            // Fecha a conexão com o banco de dados, garantindo liberação de recursos
            conexao.desconectar();
        }
        // Retorna o ResultSet contendo os anúncios inativos
        return rs;
    }
}
