package Daos;

import Daos.JDBC.Conexao;
import Model.Barraca;

import java.sql.*;


public class BarracaDAO {
    private PreparedStatement pstmt;
    Conexao conexao = new Conexao(); // Instância da classe Conexão


    public ResultSet selecionarBarracaA(){
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            // Executa a consulta SQL para selecionar barracas ativas e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_barraca where deletedat is null ");

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }

    }

    public ResultSet selecionarBarracaI(){
        try {
            //Abrindo conexão com o banco de dados
            conexao.conectar();

            // Executa a consulta SQL para selecionar barracas inativas e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_barraca where deletedat is not null ");

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }

    }

    public boolean cadastrarBarraca(Barraca barraca){
        try {
            //Abrindo conexão com o banco de dados
            conexao.conectar();

            // Comando SQL
            try(PreparedStatement pstm = conexao.getConn().prepareStatement
                    ("INSERT INTO tb_barraca (var_nome, fk_int_id_evento,createdat) " +
                            "VALUES (?,?,current_date)")){

                pstm.setString(1, barraca.getNome());
                pstm.setInt(2,barraca.getFkEvento());

                // Executando os comandos SQL no banco de dados
                int resultado = pstm.executeUpdate();

                //Validação das linhas afetadas
                if (resultado>0){
                    return true;}
                else {
                    return false;
                }
            }

        }
        catch (SQLException sqle) {
            return false;
        }
        finally {
            conexao.desconectar(); //Fechando conexão com o banco de dados
        }
    }



    public boolean atualizarBarraca(String nomeCampo, String campoAtualizado, int pkCampo) {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            //Comando SQL
            String query ="UPDATE tb_barraca SET " + nomeCampo + " = ? ,updateat = current_date WHERE pk_int_id_barraca = ? and deletedat is null";
            PreparedStatement pstmt = conexao.getConn().prepareStatement(query);

            //Setandos os parâmetros
            pstmt.setString(1, campoAtualizado);
            pstmt.setInt(2, pkCampo);

            //Retorno true se as linhas alteradas forem mais de 0
            return pstmt.executeUpdate()>0;

            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return false;
            } finally {
                conexao.desconectar(); // Fechando a conexão com o banco de dados
            }
        }


    public boolean softDeleteBarraca(int idBarraca){
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            //Comando SQL
            String query = "UPDATE tb_barraca SET deletedat = current_date," +
                    " updateat = current_date WHERE pk_int_id_barraca = " + idBarraca;

            // Método chamado para executar a query e retornar um integer da quantidade de linhas afetadas
            int resultado= conexao.executarDelete(query);

            //Validação das linhas afetadas
            if (resultado > 0){
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

