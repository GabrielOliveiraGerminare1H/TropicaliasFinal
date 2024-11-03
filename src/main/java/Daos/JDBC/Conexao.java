package Daos.JDBC;

import java.sql.*;

public class Conexao {
    private Connection conn; // Objeto de conexão com o banco de dados
    private PreparedStatement pstmt; // Objeto para preparar e executar comandos SQL
    private ResultSet rs; // Objeto para armazenar os resultados das consultas SQL

    // Método para estabelecer a conexão com o banco de dados
    public void conectar() {
        try {
            // Carrega o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Estabelece a conexão com o banco de dados usando URL, usuário e senha
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://pg-11d01e0e-testepgsql.e.aivencloud.com:24931/banco1_dev",
                    "avnadmin",
                    "AVNS_69W0O2_65jEqbsCuztW"
            );
        } catch (ClassNotFoundException cnfe) {
            // Trata exceção caso o driver do PostgreSQL não seja encontrado
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            // Trata exceção caso ocorra erro ao tentar conectar ao banco
            sqle.printStackTrace();
        }
    }

    // Método para fechar a conexão com o banco de dados
    public void desconectar() {
        try {
            // Fecha a conexão se ela estiver aberta
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException sqles) {
            // Trata exceção caso ocorra erro ao tentar fechar a conexão
            sqles.printStackTrace();
        }
    }

    // Método para obter a conexão atual
    public Connection getConn() {
        // Verifica se a conexão é nula e a cria se necessário
        if (this.conn == null) {
            conectar();
        }
        return this.conn;
    }

    // Métodos getter para PreparedStatement e ResultSet, se forem necessários externamente
    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public ResultSet getRs() {
        return rs;
    }
}
