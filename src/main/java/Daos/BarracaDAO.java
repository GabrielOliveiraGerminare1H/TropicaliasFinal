package Daos;

import Daos.JDBC.Conexao;
import Model.Barraca;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarracaDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public boolean cadastrarBarraca(Barraca barraca){
        try {
//            Abrindo conexão com o banco de dados
            conexao.conectar();
//            Comandos SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_barraca (var_nome, fk_int_id_evento,createdat) VALUES (?,?,current_date)");
//          Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setString(1, barraca.getNome());
            pstmt.setInt(2, barraca.getFk_int_id_evento());
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceção e irá retornar false
            pstmt.execute();
            return true;
        }
//        Tratando exceção SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }


    public ResultSet selecionarBarracaA(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca where deletedat is null ");

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

    public ResultSet selecionarBarracaI(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_barraca where deletedat is not null ");

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


    public boolean softDeleteBarraca(int idBarraca){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
             pstmt = conexao.getConn().prepareStatement("UPDATE tb_barraca SET deletedAt = current_date and updatedAt = current_date where pk_int_id_barraca = ?");
//            Setando os parâmetros
            pstmt.setInt(1, idBarraca);
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
//       Tratando exceção
        catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }

    public boolean atualizarBarraca(String nomeCampo, String valorNovo, int pkCampo) {
        try {
            conexao.conectar();
            pstmt = conexao.getConn().prepareStatement("Update tb_barraca set ? = ? where id = ?");
            pstmt.setString(1, nomeCampo);
            pstmt.setString(2, valorNovo);
            pstmt.setInt(3, pkCampo);
            ResultSet rs = pstmt.executeQuery();
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
            else {
                return false;
            }


        } catch (SQLException sqle) {
            return false;


        } finally {
            conexao.desconectar();
        }
    }

}

