package Controller.Barraca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CadastroBarraca" , value = "/tabCadastrarBarraca")
public class CadastrarBarraca extends HttpServlet {
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {

     }


}
