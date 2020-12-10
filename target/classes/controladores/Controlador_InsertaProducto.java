package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ProductoDAO;
import modelo.Producto;

/**
 * Servlet implementation class Controlador_InsertaUsuario
 */
@WebServlet("/Controlador_InsertaProducto")
public class Controlador_InsertaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private ProductoDAO productoDAO;
   
    public Controlador_InsertaProducto() {
       
    }

    //método desde el cual arranca el servlet
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibo los parámetros del formulario
		try {
			productoDAO =new ProductoDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		String codProd=request.getParameter("txtCod");
		LocalDate fecha=LocalDate.parse(request.getParameter("txtFecha"));
		Boolean importado=Boolean.parseBoolean(request.getParameter("txtImportado"));
		String nombreprod=request.getParameter("txtNom");
		String pais=request.getParameter("txtPais");
		Double precio=Double.parseDouble(request.getParameter("txtPrecio"));
		String seccion=request.getParameter("txtSeccion");
		if (fecha!=null && importado!=null && nombreprod!="" && pais!="" && precio!=null && seccion!="") {
			
			Producto u=new Producto(codProd,seccion,nombreprod,precio,fecha,importado,pais);
			try {
				if (productoDAO.create(u))
						request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			} catch (SQLException e) {
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
