package Daos.JDBC;

import Model.CorMascote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorMascoteDAO {
    ConexaoDAO conexao = new ConexaoDAO();

    public boolean cadastrarCorMascote(CorMascote corMascote){
        try{
            //Abrindo conexão com o banco
            conexao.conectar();
            //Comandos sql
            PreparedStatement pstmt =conexao.getConn().prepareStatement
                    ("INSERT INTO tb_cor_mascote (text_fundo, text_primaria, text_secundaria, createdAt) " +
                            "VALUES(?,?,?,current_date)");
            //Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setString(1,corMascote.getTextoFundo());
            pstmt.setString(2,corMascote.getTextoPri());
            pstmt.setString(3, corMascote.getTextoSec());
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
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

    public ResultSet buscarCorMascoteAtivo(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
//            Comando SQL
            PreparedStatement pstmt= conexao.getConn().prepareStatement("SELECT * FROM tb_cor_mascote where deletedat is null ORDER BY pk_int_id_cor_mascote");
            //executando o comando e guardando o resultset
            ResultSet rset = pstmt.executeQuery();
//            Se tudo deu certo irá retornar o resultset
            return rset;
        }
//        Tratando exceção do banco e voltando null
        catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
//        Fechando conexão com banco de dados
        finally {
            conexao.desconectar();
        }
    }

    public boolean softDeleteCorMascote(int idCorMascote){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
            PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE tb_cor_mascote SET deletedAt = current_date and updatedAt = current_date WHERE pk_int_id_cor_mascote = ?");
//            Setando os parâmetros
            pstmt.setInt(1, idCorMascote);
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
//       Tratando exceção
        catch(SQLException sqles){
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }
}
