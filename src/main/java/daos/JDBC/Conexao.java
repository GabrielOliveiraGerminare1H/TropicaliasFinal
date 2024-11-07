package daos.JDBC;

import java.sql.*;

public class Conexao {
    private Connection conn;

    //Método conectar que abre conexão com o banco de dados

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    System.getenv("DB_HOST"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD")
            );
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    // Método desconectar para fechar a conexão com o banco de dados
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException sqles) {
            // Trata erro ao tentar fechar a conexão
            sqles.printStackTrace();
        }
    }

   // Método getter do atributo conn
    public Connection getConn(){
        if (this.conn == null) {
            conectar();
        }
        return this.conn;
    }

    // Método executarSelect que executa o comando SQL do parâmetro
    public ResultSet executarSelect(String query) throws SQLException {
        // Prepara a instrução SQL
        PreparedStatement pstmt = conn.prepareStatement(query);

        // Executa a consulta e retorna o conjunto de resultados
        return pstmt.executeQuery();
    }


    // Método executarUpdate que executa o comando SQL do parâmetro
    public int executarDelete(String query) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(query)){

            // Executa a consulta e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        }
    }

    // Método que verifica se a PK existe na tabela do banco de dados
    public boolean isPkValida(String nomeTabela , String campoPk, int pkTabela)
            throws SQLException {
        try {
            //Abrindo conexão com o banco de dados
            conectar();

            //Comando sql
            PreparedStatement pstmt = conn.prepareStatement("select * from ? where ? = ?");

            //Setando os parãmetros
            pstmt.setString(1, nomeTabela);
            pstmt.setString(2, campoPk);
            pstmt.setInt(3, pkTabela);

            //Excutando comando

            pstmt.executeQuery();
            return true;


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        finally {
            desconectar(); //Fechando conexão com o banco de dados
        }

    }

    // Método que verifica se a FK existe na tabela do banco de dados
    public boolean isFkValida(String nomeTabela , String campoFk, int fkTabela)
            throws SQLException {
        try {
            //Abrindo conexão com o banco de dados
            conectar();

            String sql = "SELECT * FROM " + nomeTabela + " WHERE " + campoFk + " = ?";

            // Criando o PreparedStatement com o comando SQL dinâmico
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Setando o parâmetro de valor (fkTabela)
            pstmt.setInt(1, fkTabela);

            // Executando a consulta
            ResultSet rs = pstmt.executeQuery();

            // Verificando se há resultados
            if (rs.next()) {
                // Se houver resultados, retornar true
                return true;
            } else {
                // Caso contrário, retornar false
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        finally {
            desconectar(); //Fechando conexão com o banco de dados
        }

    }



}
