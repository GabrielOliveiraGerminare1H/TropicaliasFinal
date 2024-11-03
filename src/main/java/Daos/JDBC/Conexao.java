package Daos.JDBC;

import java.sql.*;

public class Conexao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://pg-11d01e0e-testepgsql.e.aivencloud.com:24931/banco1_dev",
                    "avnadmin",
                    "AVNS_69W0O2_65jEqbsCuztW"
            );
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    //    metodo para fechar conexão com o banco de dados
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException sqles) {
            sqles.printStackTrace();
        }
    }

    public Connection getConn(){
        if (this.conn == null) {
            conectar();
        }
        return this.conn;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public ResultSet getRs() {
        return rs;
    }
}
