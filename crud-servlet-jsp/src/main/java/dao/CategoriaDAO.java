package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {
	
	public String inserir(Categoria categoria) throws SQLException {
		String retorno = "falha";
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			stmt.execute("INSERT INTO categoria (nome) VALUES ('"+categoria.getNome() + "')");
			retorno = "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}		
		return retorno;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from categoria");
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setCodigo(rs.getInt("codigo"));
				categoria.setNome(rs.getString("nome"));
				categorias.add(categoria);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}
		return categorias;
	}

	public String delete(Integer codigo) throws SQLException {
		Conexao conn = new Conexao();
		String retorno =  "";

		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			stmt.executeQuery("delete from categoria where codigo="+codigo);

			retorno = "sucesso";

		} catch (Exception e) {
			e.printStackTrace();

			retorno = "Erro!: "+ e.getMessage();
		} finally {
			conn.fecharConexao();
		}

		return retorno;
	}

	public String update(Categoria categoria) throws SQLException {
		String response = "";
		Conexao conn = new Conexao();
		try
		{
			Statement stmt = (Statement) conn.getConn().createStatement();
			stmt.executeQuery("UPDATE table_name SET nome=" +categoria.getNome() +
								 " WHERE codigo="+categoria.getCodigo());

			response = "Sucesso";
		}
		catch (Exception e)
		{
			e.printStackTrace();

			response = "Erro! "+ e.getMessage();
		} finally
		{
			conn.fecharConexao();
		}

		return response;
	}
}