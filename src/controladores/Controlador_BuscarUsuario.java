package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_InsertaUsuario
 */
@WebServlet("/Controlador_BuscarUsuario")
public class Controlador_BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
   
    public Controlador_BuscarUsuario() {
       
    }

    //método desde el cual arranca el servlet
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibo los parámetros del formulario
		try {
			usuarioDAO =new UsuarioDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		Long id=Long.parseLong(request.getParameter("txtId"));
		Usuario a = usuarioDAO.read(id);
		System.out.print("El id es: "+id);
		if (id!=null) {
			try {
				if (usuarioDAO.read(id)!=null)
						request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			}
		}	
		else
					request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
