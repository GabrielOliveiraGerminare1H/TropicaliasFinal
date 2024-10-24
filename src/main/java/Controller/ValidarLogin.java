//package Controller;
//
//import Daos.JDBC.UsuarioDAO;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(name = "Validar Login", value = "/conta")
//public class ValidarLogin extends HttpServlet  {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            String nome=request.getParameter("name");
//            String email=request.getParameter("email");
//            String senha=request.getParameter("senha");
//
//            boolean loginValido = validarLogin("email","senha");
//
//            if (loginValido){
//                response.sendRedirect("telasadmim.html");
//
//            }else {
//                response.sendRedirect("acessoNegado.jsp");
//            }
//
//
//        }catch (NumberFormatException nfe){
//
//            request.setAttribute("errorMessage",nfe.getMessage());
//            request.getRequestDispatcher("erro.jsp").forward(request,response);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private boolean validarLogin(String email, String senha){
//       boolean aprovado=false;
//        if (UsuarioDAO.validarLogin(email,senha)){
//            aprovado=true;
//        }
//
//        return aprovado;
//
//    }
//
//
//}
