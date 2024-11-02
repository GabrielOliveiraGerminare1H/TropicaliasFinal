package Daos;

import Daos.JDBC.Conexao;
import Model.Evento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventoDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public boolean cadastrarEvento(Evento evento) {
        try {
//            Abrindo conexão com o banco
            conexao.conectar();

//           Comandos SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_evento (dt_inicio,dt_final,var_nome, var_local, num_preco_ticket, fk_int_id_usuario, updatedAt)\n" +
                    "VALUES(?,?,?,?,?,?,current_date)");
//            Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setDate(1, java.sql.Date.valueOf(evento.getDt_inicio()));
            pstmt.setDate(2, java.sql.Date.valueOf(evento.getDt_final()));
            pstmt.setString(3, evento.getNome());
            pstmt.setString(4, evento.getLocal());
            pstmt.setDouble(5, evento.getPrecoTicket());
            pstmt.setInt(6, evento.getFk_int_id_usuario());
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
        //        Tratando exceção do Banco SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        }
        //        Desconectando do Banco de dados
        finally {
            conexao.desconectar();
        }

    }


    public boolean atualizarEvento(String nomeCampo, String atualizacaoCampo, int pk_int_id_evento) {

        conexao.conectar(); //Abrindo a conexão com o banco

        try {

            pstmt = conn.prepareStatement("UPDATE tb_evento SET " + nomeCampo + " = ?, updateat = current_date WHERE pk_int_id_evento = ?"
            );


            pstmt.setString(1, nomeCampo);
            
            if (Objects.equals(nomeCampo, "var_nome") || Objects.equals(nomeCampo, "var_local")) {
                pstmt.setString(2, atualizacaoCampo);
            } else if (Objects.equals(nomeCampo, "dt_inicio") || Objects.equals(nomeCampo, "dt_final")) {
                LocalDate campo = LocalDate.parse(atualizacaoCampo);
                pstmt.setDate(2, Date.valueOf(campo));
            } else if (Objects.equals(nomeCampo, "num_preco_ticket")) {
                pstmt.setDouble(2, Double.parseDouble(atualizacaoCampo));
            } else if (Objects.equals(nomeCampo, "fk_int_id_usuario")) {
                pstmt.setInt(2, Integer.parseInt(atualizacaoCampo));
            } else {
                return false;
            }

            pstmt.setInt(3, pk_int_id_evento);

            if (pstmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException sqle) {
            return false;
        } finally {
            conexao.desconectar(); //Fechando a conexão com o banco
        }

    }

    public boolean softDeleteEvento(int idEvento){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
            pstmt = conexao.getConn().prepareStatement("UPDATE tb_evento SET deletedat = current_date, updateat = current_date WHERE pk_int_id_evento = ?"
            );
//            Setando os parâmetros
            pstmt.setInt(1, idEvento);
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

    public ResultSet selecionarEventoA(){
        try{
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from tb_evento where deletedat is null");
            rs = pstmt.executeQuery();



        }catch(SQLException sqle){
            return null;

        }
        finally {
            conexao.desconectar();

        }
        return rs;
    }

    public ResultSet selecionarEventoI(){
        try{
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from tb_evento where deletedat is not null");
            rs = pstmt.executeQuery();



        }catch(SQLException sqle){
            return null;

        }
        finally {
            conexao.desconectar();

        }
        return rs;
    }


}


