package Daos;

import Daos.JDBC.Conexao;
import Model.Evento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventoDAO {
    private Conexao conexao = new Conexao();

    public boolean cadastrarEvento(Evento evento) {
        try {
            // Abrindo conexão com o banco
            conexao.conectar();

            // Comandos SQL
            try (PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_evento (dt_inicio, dt_final, var_nome, var_local, num_preco_ticket, fk_int_id_usuario, updatedAt) VALUES (?, ?, ?, ?, ?, ?, current_date)")) {
                // Setando os parâmetros para fazer a inserção no banco de dados
                pstmt.setDate(1, java.sql.Date.valueOf(evento.getDt_inicio()));
                pstmt.setDate(2, java.sql.Date.valueOf(evento.getDt_final()));
                pstmt.setString(3, evento.getNome());
                pstmt.setString(4, evento.getLocal());
                pstmt.setDouble(5, evento.getPrecoTicket());
                pstmt.setInt(6, evento.getFk_int_id_usuario());
                // Executando os comandos SQL no banco
                pstmt.executeUpdate(); // Use executeUpdate para INSERT
                return true;
            }
        } catch (SQLException sqles) {
            sqles.printStackTrace(); // Imprimindo a pilha de erros
            return false;
        } finally {
            conexao.desconectar(); // Desconectando do Banco de dados
        }
    }

    public boolean atualizarEvento(String nomeCampo, String atualizacaoCampo, int pk_int_id_evento) {
        try {
            conexao.conectar(); // Abrindo a conexão com o banco
            try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE tb_evento SET " + nomeCampo + " = ?, updateat = current_date WHERE pk_int_id_evento = ?")) {
                if (Objects.equals(nomeCampo, "var_nome") || Objects.equals(nomeCampo, "var_local")) {
                    pstmt.setString(1, atualizacaoCampo);
                } else if (Objects.equals(nomeCampo, "dt_inicio") || Objects.equals(nomeCampo, "dt_final")) {
                    LocalDate campo = LocalDate.parse(atualizacaoCampo);
                    pstmt.setDate(1, Date.valueOf(campo));
                } else if (Objects.equals(nomeCampo, "num_preco_ticket")) {
                    pstmt.setDouble(1, Double.parseDouble(atualizacaoCampo));
                } else if (Objects.equals(nomeCampo, "fk_int_id_usuario")) {
                    pstmt.setInt(1, Integer.parseInt(atualizacaoCampo));
                } else {
                    return false;
                }

                pstmt.setInt(2, pk_int_id_evento);

                return pstmt.executeUpdate() > 0; // Retorna true se a atualização foi bem-sucedida
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprimindo a pilha de erros
            return false;
        } finally {
            conexao.desconectar(); // Fechando a conexão com o banco
        }
    }

    public boolean softDeleteEvento(int idEvento) {
        try {
            conexao.conectar(); // Conectando ao banco de dados
            try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE tb_evento SET deletedat = current_date, updateat = current_date WHERE pk_int_id_evento = ?")) {
                pstmt.setInt(1, idEvento);
                pstmt.executeUpdate(); // Use executeUpdate para UPDATE
                return true;
            }
        } catch (SQLException sqles) {
            sqles.printStackTrace(); // Imprimindo a pilha de erros
            return false;
        } finally {
            conexao.desconectar(); // Fechando conexão com o banco de dados
        }
    }

    public ResultSet selecionarEventoA() {
        try {
            conexao.conectar();
            PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_evento WHERE deletedat IS NULL");
            return pstmt.executeQuery(); // Retorna ResultSet, lembre-se de fechá-lo depois
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprimindo a pilha de erros
            return null;
        }
    }

    public ResultSet selecionarEventoI() {
        try {
            conexao.conectar();
            PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM tb_evento WHERE deletedat IS NOT NULL");
            return pstmt.executeQuery(); // Retorna ResultSet, lembre-se de fechá-lo depois
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprimindo a pilha de erros
            return null;
        }
    }
}
