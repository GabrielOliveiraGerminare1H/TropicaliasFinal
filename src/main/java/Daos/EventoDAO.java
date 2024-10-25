package Daos;

import Daos.JDBC.ConexaoDAO;
import Model.Evento;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class EventoDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    ConexaoDAO conexao = new ConexaoDAO();

    public boolean cadastrarEvento(Evento evento) {
        try {
//            Abrindo conexão com o banco
            conexao.conectar();

//           Comandos SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_evento (dt_inicio,dt_final,var_nome, var_local, num_preco_ticket, fk_int_id_usuario, updatedAt)\n" +
                    "VALUES(?,?,?,?,?,?,current_date)");
//            Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setDate(1, evento.getDt_inicio());
            pstmt.setDate(2, evento.getDt_final());
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

    public ResultSet buscarEvento() {
        try {
            //abrindo conexão com o banco
            conexao.conectar();
            pstmt = conexao.getConn().prepareStatement("SELECT nome FROM tb_evento ORDER BY pk_int_id_evento");
            //executando o comando e guardando o resultset
            ResultSet rset = pstmt.executeQuery();
            return rset;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }

    }

    public boolean atualizarEvento(String nomeCampo, String atualizacaoCampo, int pk_int_id_evento) {

        conexao.conectar(); //Abrindo a conexão com o banco

        try {

            pstmt = conn.prepareStatement("UPDATE tb_evento SET ? = ?, updatedat = current_date WHERE pk_int_id_evento = ?");

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
            pstmt = conexao.getConn().prepareStatement("UPDATE tb_evento SET deletedAt = current_date and updatedAt = current_date WHERE pk_int_id_evento = ?");
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
}
