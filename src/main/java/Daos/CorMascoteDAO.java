package Daos;

import Daos.JDBC.Conexao;
import Model.CorMascote;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CorMascoteDAO {
    Conexao conexao = new Conexao(); // Instância da classe Conexão


    public ResultSet selecionarCorMascoteA(){
        try {
            // Abrindo conexão com o banco
            conexao.conectar();

            // Executa a consulta SQL para selecionar cores do mascote ativas e retorna um ResultSet
            return conexao.executarSelect("select * from tb_cor_mascote where deletedat is null ");

        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar(); // Fechando a conexão com banco de dados
        }

    }

    public ResultSet selecionarCorMascoteI(){
        try{
            // Abrindo conexão com o banco
            conexao.conectar();

            // Executa a consulta SQL para selecionar cores do mascote inativas e retorna um ResultSet
            return conexao.executarSelect("select * from tb_cor_mascote where deletedat is not null ");
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }

    }

    public boolean cadastrarCorMascote(CorMascote corMascote){
        try{
            // Abrindo conexão com o banco
            conexao.conectar();

            // Comando SQL
            try(PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "INSERT INTO tb_cor_mascote (text_fundo, text_primaria, text_secundaria, createdat) " +
                            "VALUES(?,?,?,current_date)")){
                // Setando os parâmetros para a inserção no banco de dados
                pstmt.setString(1, corMascote.getTextoFundo());
                pstmt.setString(2, corMascote.getTextoPri());
                pstmt.setString(3, corMascote.getTextoSec());

                // Executando os comandos SQL no banco de dados
                int resultado = pstmt.executeUpdate();

                //Validação das linhas afetadas
                if (resultado>0){
                    return true;}
                else {
                    return false;
                }
            }
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }


    public boolean atualizarCorMascote(String nomeCampo, String campoAtualizado, int pkCorMascote) {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            //Comando SQL
            String query ="UPDATE tb_cor_mascote SET " + nomeCampo + " = '" + campoAtualizado +
                    "' ,updateat = current_date WHERE pk_int_id_cor_mascote = " + pkCorMascote + "and deletedat is null";

            // Método chamado para executar a query e retornar um integer da quantidade de linhas afetadas
            int resultado= conexao.executarUpdate(query);

            //Validação das linhas afetadas
            if (resultado>0){
                return true;}
            else {
                return false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }



    public boolean softDeleteCorMascote(int idCorMascote) {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            //Comando SQL
            String query ="UPDATE tb_cor_mascote SET deletedat = current_date, " +
                    "updateat = current_date WHERE pk_int_id_cor_mascote = " + idCorMascote;

            // Método chamado para executar a query e retornar um integer da quantidade de linhas afetadas
            int resultado= conexao.executarUpdate(query);

            //Validação das linhas afetadas
            if (resultado>0){
                return true;}
            else {
                return false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }

    }







}
