package Daos;

import Daos.JDBC.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnuncioDAO {
    private Conexao conexao = new Conexao();


    public ResultSet selecionarAnuncioA() {
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            // Executa a consulta SQL para selecionar anúncios ativos e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_anuncio WHERE deletedat IS NULL");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }

    public ResultSet selecionarAnuncioI() {
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            // Executa a consulta SQL para selecionar anúnios inativos e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_anuncio WHERE deletedat IS NOT NULL");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }
}
