package controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.CategoriaDAO;
import model.Categoria;

@WebServlet("/")
public class ListarCategoria extends HttpServlet
{

    CategoriaDAO dao = new CategoriaDAO();

    public List<Categoria> get(){

        List<Categoria> categoriaList = new ArrayList<>();

        try
        {
            categoriaList = dao.listar();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return categoriaList;
    }
}
