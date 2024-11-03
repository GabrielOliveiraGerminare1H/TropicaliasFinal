//package Daos;
//
//import Daos.JDBC.Conexao;
//import Model.Evento;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class EventoDAO {
//    Conexao conexao = new Conexao();
//
//    public boolean cadastrarEvento(Evento evento) {
//        try {
////            Abrindo conexão com o banco
//            conexao.conectar();
//
////           Comandos SQL
//            conexao.getPstmt() = conexao.getConn().prepareStatement("INSERT INTO tb_evento (dt_inicio,dt_final,var_nome, var_local, num_preco_ticket, fk_int_id_usuario, updatedAt)\n" +
//                    "VALUES(?,?,?,?,?,?,current_date)");
////            Setando os parâmetros para fazer a inserção no banco de dados
//            conexao.getPstmt().setDate(1, java.sql.Date.valueOf(evento.getDt_inicio()));
//            conexao.getPstmt().setDate(2, java.sql.Date.valueOf(evento.getDt_final()));
//            conexao.getPstmt().setString(3, evento.getNome());
//            conexao.getPstmt().setString(4, evento.getLocal());
//            conexao.getPstmt().setDouble(5, evento.getPrecoTicket());
//            conexao.getPstmt().setInt(6, evento.getFk_int_id_usuario());
////          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
//            conexao.getPstmt().execute();
//            return true;
//        }
//        //        Tratando exceção do Banco SQL
//        catch (SQLException sqles) {
//            sqles.printStackTrace();
//            return false;
//        }
//        //        Desconectando do Banco de dados
//        finally {
//            conexao.desconectar();
//        }
//
//    }
//
//
//    public boolean atualizarEvento(String nomeCampo, String atualizacaoCampo, int pk_int_id_evento) {
//
//        conexao.conectar(); //Abrindo a conexão com o banco
//
//        try {
//
//            conexao.getPstmt() = conexao.getConn().prepareStatement("UPDATE tb_evento SET ? = ?, updatedat = current_date WHERE pk_int_id_evento = ?");
//
//            conexao.getPstmt().setString(1, nomeCampo);
//
//            if (Objects.equals(nomeCampo, "var_nome") || Objects.equals(nomeCampo, "var_local")) {
//                conexao.getPstmt().setString(2, atualizacaoCampo);
//            } else if (Objects.equals(nomeCampo, "dt_inicio") || Objects.equals(nomeCampo, "dt_final")) {
//                LocalDate campo = LocalDate.parse(atualizacaoCampo);
//                conexao.getPstmt().setDate(2, Date.valueOf(campo));
//            } else if (Objects.equals(nomeCampo, "num_preco_ticket")) {
//                conexao.getPstmt().setDouble(2, Double.parseDouble(atualizacaoCampo));
//            } else if (Objects.equals(nomeCampo, "fk_int_id_usuario")) {
//                conexao.getPstmt().setInt(2, Integer.parseInt(atualizacaoCampo));
//            } else {
//                return false;
//            }
//
//            conexao.getPstmt().setInt(3, pk_int_id_evento);
//
//            if (conexao.getPstmt().executeUpdate() > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException sqle) {
//            return false;
//        } finally {
//            conexao.desconectar(); //Fechando a conexão com o banco
//        }
//
//    }
//
//    public boolean softDeleteEvento(int idEvento){
//        try{
////            Conectando ao banco de dados
//            conexao.conectar();
////            Comando SQl
//            conexao.getPstmt() = conexao.getConn().prepareStatement("UPDATE tb_evento SET deletedAt = current_date and updatedAt = current_date WHERE pk_int_id_evento = ?");
////            Setando os parâmetros
//            conexao.getPstmt().setInt(1, idEvento);
////          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
//            conexao.getPstmt().execute();
//            return true;
//        }
////       Tratando exceção
//        catch(SQLException sqles){
//            sqles.printStackTrace();
//            return false;
//        }
////        Fechando conexão com o banco de dados
//        finally {
//            conexao.desconectar();
//        }
//    }
//
//    public ResultSet selecionarEventoA(){
//        try{
//            conexao.conectar();
//
//            conexao.getPstmt() = conexao.getConn().prepareStatement("select * from tb_evento where deletedat is null");
//            conexao.getRs() = conexao.getPstmt().executeQuery();
//
//
//
//        }catch(SQLException sqle){
//            return null;
//
//        }
//        finally {
//            conexao.desconectar();
//
//        }
//        return conexao.getRs();
//    }
//
//    public ResultSet selecionarEventoI(){
//        try{
//            conexao.conectar();
//
//            conexao.getPstmt() = conexao.getConn().prepareStatement("select * from tb_evento where deletedat is not null");
//            conexao.getRs() = conexao.getPstmt().executeQuery();
//
//
//
//        }catch(SQLException sqle){
//            return null;
//
//        }
//        finally {
//            conexao.desconectar();
//
//        }
//        return conexao.getRs();
//    }
//
//
//}
//
//
