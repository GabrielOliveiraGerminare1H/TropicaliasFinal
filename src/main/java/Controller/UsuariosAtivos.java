package Controller;
import Daos.JDBC.UsuarioDAO;
import Model.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Cadastro Tropicalias", value = "/tabUsuariosAtivos")
public class UsuariosAtivos extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{

            List<Usuario> usuariosA = usuarioDAO.buscarUsuario();

            request.setAttribute(usuariosA.toString(),"usuariosA");

            request.getRequestDispatcher("selectUsuariosA.jsp").forward(request,response);


        }catch (NumberFormatException nfe){

        }



    }
}
