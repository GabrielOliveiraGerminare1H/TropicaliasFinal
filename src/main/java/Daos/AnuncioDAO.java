package Daos;

import Daos.JDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnuncioDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public ResultSet selecionarAnuncioA(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from tb_anuncio where deletedat is null");

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

    public ResultSet selecionarAnuncioI() {
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from tb_anuncio where deletedat is not null");

            //Executando o comando e guardando o resultset
            rs = pstmt.executeQuery();


        } catch (SQLException sqle) {
            return null;
        } finally {
            conexao.desconectar();
        }
        return rs;
    }
}
