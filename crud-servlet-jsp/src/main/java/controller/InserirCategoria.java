package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import model.Categoria;


@WebServlet("/InserirCategoria")
public class InserirCategoria extends HttpServlet{
   
    private static final long serialVersionUID = 1L;

    CategoriaDAO dao = new CategoriaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        try
        {
            String nome = request.getParameter("nome");
            Categoria categoria = new Categoria();
            categoria.setNome(nome);

            String retorno = dao.inserir(categoria);

            if (retorno.equals("sucesso")) {
                doGet(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.print("<html>");
                out.print("<h2> Nao foi possivel inserir a categoria!</h2>");
                out.print("<br");
                out.print("<a href = 'index.jsp'> Voltar </a>");
                out.print("</html>");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

}