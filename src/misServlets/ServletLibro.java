package misServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LibroDTO;
import service.LibroService;

@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService serviLibro = new LibroService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listar"))
			listar(request, response);
		else if (xtipo.equals("buscar"))
			buscar(request, response);
		else if (xtipo.equals("registrar"))
			registrar(request, response);
		else if (xtipo.equals("actualizar"))
			actualizar(request, response);
		else if (xtipo.equals("eliminar"))
			eliminar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("txt_cod"));
		System.out.println("Codigo a eliminar " + cod);
		serviLibro.EliminaLibro(cod);
		System.out.println("Eliminado ");	
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Libro", serviLibro.buscaLibro(cod));
		request.getRequestDispatcher("mantenimiento-liza.jsp").forward(request, response);
	}



	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviLibro.listaLibro());
		request.getRequestDispatcher("listadoLibros.jsp").forward(request, response);
	}
}