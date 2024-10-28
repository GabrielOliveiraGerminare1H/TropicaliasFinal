package Daos.JDBC;

import Model.Barraca;

import java.sql.*;

public class BarracaDAO {
    ConexaoDAO conexao = new ConexaoDAO();

    public boolean cadastrarBarraca(Barraca barraca ){
        try {
//            Abrindo conexão com o banco de dados
            conexao.conectar();
//            Comandos SQL
            PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_barraca (var_nome, fk_int_id_evento,createdat) VALUES (?,?,current_date)");
//          Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setString(1, barraca.getNome());
            pstmt.setInt(2, barraca.getFk_int_id_evento());
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

    public ResultSet buscarBarraca(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
//            Comandos SQL
            PreparedStatement pstmt= conexao.getConn().prepareStatement("SELECT * FROM tb_barraca where deletedat is null ORDER BY pk_int_id_barraca");
            //executando o comando e guardando o resultset
            ResultSet rset = pstmt.executeQuery();
//            Se tudo der certo irá retornar o resultset
            return rset;
        }
//        Tratando a exceção do banco de dados e retornado null pq deu erro
        catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
//        Desconectando do banco de dados
        finally {
            conexao.desconectar();
        }

    }

    public boolean softDeleteBarraca(int idBarraca){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
            PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE tb_barraca SET deletedAt = current_date and updatedAt = current_date pk_int_id_barraca = ?");
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

    public boolean atualizarBarraca(String nomeTabela, String nomeCampo, String valorNovo, int pkCampo) {
        try {
            conexao.conectar();
            PreparedStatement pstmt = conexao.getConn().prepareStatement("Update ? set ? = ? where id = ?");
            pstmt.setString(1, nomeTabela);
            pstmt.setString(2, nomeCampo);
            pstmt.setString(3, valorNovo);
            pstmt.setInt(4, pkCampo);
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

