package daos;

import daos.JDBC.Conexao;
import model.Evento;
import java.sql.*;


public class EventoDAO {
    private Conexao conexao = new Conexao(); // Instância da classe Conexão

    public ResultSet selecionarEventoA() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();

            // Executa a consulta SQL para selecionar eventos ativos e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_evento WHERE deletedat IS NULL");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar();//Fechando a conexão com o banco de dados
        }
    }

    public ResultSet selecionarEventoI() {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();

            // Executa a consulta SQL para selecionar eventos inativas e retorna um ResultSet
            return conexao.executarSelect("SELECT * FROM tb_evento WHERE deletedat IS NOT NULL");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar(); //Fechando a conexão com o banco de dados
        }
    }

    public boolean cadastrarEvento(Evento evento) {
        try {
            // Abrindo conexão com o banco de dados
            conexao.conectar();

            // Comando SQL
            try (PreparedStatement pstmt = conexao.getConn().prepareStatement
                    ("INSERT INTO tb_evento" +
                            "(dt_inicio, dt_final, var_nome, var_local, num_preco_ticket," +
                            "createdat, fk_int_id_usuario, var_imagem, var_descricao) " +
                            "VALUES (?, ?, ?, ?, ?, current_date,?,?,?)")) {

                java.sql.Date dt_inicio = new java.sql.Date(evento.getDtInicio().getTime());
                java.sql.Date dt_final = new java.sql.Date(evento.getDtFinal().getTime());
                // Setando os parâmetros para fazer a inserção no banco de dados
                pstmt.setDate(1, dt_inicio);
                pstmt.setDate(2, dt_final);
                pstmt.setString(3, evento.getNome());
                pstmt.setString(4, evento.getLocal());
                pstmt.setDouble(5, evento.getPrecoTicket());
                pstmt.setInt(6, evento.getFkUsuario());
                pstmt.setString(7,evento.getImagem());
                pstmt.setString(8, evento.getDescricao());

                // Executando o comando SQL no banco de dados
                int resultado = pstmt.executeUpdate();

                //Validação das linhas afetadas
                if (resultado>0){
                    return true;}
                else {
                    return false;
                }
            }
        } catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }
    }


    public boolean atualizarEvento(String nomeCampo, String campoAtualizado, int pkEvento) {
        try {
            // Abre a conexão com o banco de dados
            conexao.conectar();

            //Comando SQL
            String query ="UPDATE tb_evento SET " + nomeCampo + " = ? ,updateat = current_date WHERE pk_int_id_evento = ? and deletedat is null";
            PreparedStatement pstmt = conexao.getConn().prepareStatement(query);

            //Setandos os parâmetros
            pstmt.setString(1, campoAtualizado);
            pstmt.setInt(2, pkEvento);

            //Retorno true se as linhas alteradas forem mais de 0
            return pstmt.executeUpdate()>0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco de dados
        }

    }

    public boolean softDeleteEvento(int idEvento) {
        try {
        // Abre a conexão com o banco de dados
        conexao.conectar();

        //Comando SQL
        String query ="UPDATE tb_evento SET deletedat = current_date," +
                " updateat = current_date WHERE pk_int_id_evento = " + idEvento;

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
