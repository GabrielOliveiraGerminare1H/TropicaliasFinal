package Controller.Barraca;
import Daos.BarracaDAO;
import Daos.UsuarioDAO;
import Model.Barraca;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Cadastro Tropicalias", value = "/tabUsuariosInativos")
public class SelecionarBarracaA extends HttpServlet {

    private BarracaDAO barracaDAO = new BarracaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{

            List<Barraca> barracaA = barracaDAO.selecionarBarracaA();

            request.setAttribute("usuariosI",barracaA.toString());

            request.getRequestDispatcher("SelecinarBarracaA.jsp").forward(request,response);


        }catch (NumberFormatException nfe){

        }




    }
}
