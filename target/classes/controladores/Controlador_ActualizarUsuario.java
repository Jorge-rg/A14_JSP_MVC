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
@WebServlet("/Controlador_ActualizarUsuario")
public class Controlador_ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
   
    public Controlador_ActualizarUsuario() {
       
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
		
		
		
		
	}
	
	private void buscar(Usuario a,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibo los parámetros del formulario
		try {
			usuarioDAO =new UsuarioDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		String usuario=request.getParameter("txtUsuario");
		String contra=request.getParameter("txtContra");
		a = usuarioDAO.login(usuario, contra);
		if (usuario!="" && contra!="") {
			System.out.println(a.toString());
			if (a!=null) {
				request.getSession().setAttribute("UsuarioEncontrado",a);
			}else
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			
		}	
		else
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			
		
		
	}
	
	private void actualizar(Usuario a,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibo los parámetros del formulario
		try {
			usuarioDAO =new UsuarioDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		Usuario a2 = new Usuario(Long.parseLong(request.getParameter("txtIdEn")),request.getParameter("txtNombreEn"),
				request.getParameter("txtApellidosEn"),request.getParameter("txtUsuarioEn"),
				request.getParameter("txtContrasenaEn"),request.getParameter("txtPaisEn"),
				request.getParameter("txtTecnologiaEn"));
		if (a2!=null) {
			System.out.println(a.toString());
				request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
	
		}else
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
