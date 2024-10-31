//package Controller.Usuarios;
//import Daos.UsuarioDAO;
//import Model.Usuario;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet(name = "Cadastro Tropicalias", value = "/tabUsuariosInativos")
//public class UsuariosInativos extends HttpServlet {
//
//    private UsuarioDAO usuarioDAO = new UsuarioDAO();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try{
//
//            List<Usuario> usuariosI = usuarioDAO.selecionarUsuarioI();
//
////            request.setAttribute("usuariosI",usuariosI.toString());
//
//            request.getRequestDispatcher("selectUsuariosI.jsp").forward(request,response);
//
//
//        }catch (NumberFormatException nfe){
//
//        }
//
//
//        request.getRequestDispatcher("selecionarUsuariosI.jsp").forward(request,response);
//
//
//
//    }
//}
//
//
