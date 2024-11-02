package Daos;

import Daos.JDBC.Conexao;
import Model.CorMascote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorMascoteDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

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
            //
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }

    public ResultSet selecionarCorMascoteA(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
//            Comando SQL
             pstmt= conexao.getConn().prepareStatement("select * from tb_cor_mascote where deletedat is null ");
            //executando o comando e guardando o resultset
            rs = pstmt.executeQuery();
//            Se tudo deu certo irá retornar o resultset

        }
//        Tratando exceção do banco e voltando null
        catch (SQLException sqle){
            return null;
        }
//        Fechando conexão com banco de dados
        finally {
            conexao.desconectar();
        }
        return rs;
    }


    public ResultSet selecionarCorMascoteI(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
//            Comando SQL
            pstmt= conexao.getConn().prepareStatement("select * from tb_cor_mascote where deletedat is not null ");
            //executando o comando e guardando o resultset
            rs = pstmt.executeQuery();
//            Se tudo deu certo irá retornar o resultset

        }
//        Tratando exceção do banco e voltando null
        catch (SQLException sqle){
            return null;
        }
//        Fechando conexão com banco de dados
        finally {
            conexao.desconectar();
        }
        return rs;
    }

    public boolean softDeleteCorMascote(int idCorMascote) {
        try {
            // Conectando ao banco de dados
            conexao.conectar();

            // Comando SQL
            PreparedStatement pstmt = conexao.getConn().prepareStatement(
                    "UPDATE tb_cor_mascote SET deletedAt = current_date, updatedAt = current_date WHERE pk_int_id_cor_mascote = ?"
            );

            // Setando os parâmetros
            pstmt.setInt(1, idCorMascote);

            // Executando o comando SQL e retornando o resultado da verificação
            return pstmt.executeUpdate() > 0;

        } catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;

        } finally {
            // Fechando a conexão com o banco de dados
            conexao.desconectar();
        }
    }



//    public List<CorMascote> listarCorMascoteAtivo(){
//        List<CorMascote> corMascotes = new ArrayList<>();
//        try{
//            //abrindo conexão com o banco
//            conexao.conectar();
////            Comando SQL
//            PreparedStatement pstmt= conexao.getConn().prepareStatement("SELECT * FROM tb_cor_mascote where deletedat is null");
//            //executando o comando e guardando o resultset
//            ResultSet rset = pstmt.executeQuery();
////            Se tudo deu certo irá retornar o resultset
//            while (rset.next()){
//                CorMascote corMascote = new CorMascote();
//                corMascote.setTextoFundo(rset.getString("text_fundo"));
//                corMascote.setTextoPri(rset.getString("text_primaria"));
//                corMascote.setTextoSec(rset.getString("text_secundaria"));
//
//                corMascotes.add(corMascote);
//            }
//        }
////        Tratando exceção do banco e voltando null
//        catch (SQLException sqle){
//            sqle.printStackTrace();
//            return null;
//        }
////        Fechando conexão com banco de dados
//        finally {
//            conexao.desconectar();
//        }
//
//        return corMascotes;
//    }


    public boolean atualizarCorMascote(String nomeCampo, String atualizacaoCampo, int pkCorMascote) {
        // Lista de campos válidos para evitar SQL injection
        if (!nomeCampo.equals("text_fundo") && !nomeCampo.equals("text_primaria") && !nomeCampo.equals("text_secundaria")) {
            System.out.println("Campo inválido: " + nomeCampo);
            return false;
        }

        try {
            // Conectar ao banco de dados
            conexao.conectar();

            // Criar consulta SQL com o nome do campo diretamente na string (já validado)
            String sql = "UPDATE tb_cor_mascote SET " + nomeCampo + " = ?, updatedAt = current_date WHERE pk_int_id_cor_mascote = ?";
            PreparedStatement pstmt = conexao.getConn().prepareStatement(sql);

            // Definir os parâmetros
            pstmt.setString(1, atualizacaoCampo);
            pstmt.setInt(2, pkCorMascote);

            // Executar atualização e retornar o sucesso da operação
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fechar conexão com o banco de dados
            conexao.desconectar();
        }
    }}









