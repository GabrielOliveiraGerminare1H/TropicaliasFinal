package Daos;

import Daos.JDBC.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Conexao conexao = new Conexao();

    public ResultSet selecionarUsuarioA() {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            // Executa a consulta SQL para selecionar usuários ativos e retorna um ResultSet
            return conexao.executarSelect("select * from tb_usuario where deletedat is null");

        } catch (SQLException sqle) {
           sqle.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }


    public ResultSet selecionarUsuarioI() {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            // Executa a consulta SQL para selecionar usuários inativos e retorna um ResultSet
            return conexao.executarSelect("select * from tb_usuario where deletedat is not null");


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }
}
