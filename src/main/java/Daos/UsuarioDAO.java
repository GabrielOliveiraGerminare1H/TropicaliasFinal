package Daos;


import Daos.JDBC.ConexaoDAO;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    ConexaoDAO conexao = new ConexaoDAO();

    public List<Usuario> buscarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            //Abrindo conexão com o banco
            conexao.conectar();

            pstmt = conexao.getConn().prepareStatement("select * from usuario where deletedat is null");

            //Executando o comando e guardando o resultset
            rs= pstmt.executeQuery();

            if(rs.next()){
                do{
                    Usuario usuario= new Usuario(rs.getString("text_foto"),rs.getString("var_email"),
                            rs.getString("var_senha"),rs.getString("var_user_name"),
                            rs.getDate("dt_nascimento"),rs.getString("var_descricao_usuario"),
                            rs.getLong("var_cpf"),rs.getString("var_nome"),rs.getInt("fk_int_id_endereco"));

                    usuarios.add(usuario);
                } while(rs.next());
            }
            else{
                return null;
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar();
        }

        return usuarios;


    }
}