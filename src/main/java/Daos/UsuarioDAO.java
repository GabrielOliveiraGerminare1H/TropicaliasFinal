package Daos;


import Daos.JDBC.Conexao;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public ResultSet selecionarUsuarioA(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from usuario where deletedat is null");

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

    public ResultSet selecionarUsuarioI() {
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from usuario where deletedat is not null");

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