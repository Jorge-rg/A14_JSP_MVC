package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Producto;
import modelo.Usuario;

//conecta JavaBean  con la base de datos

public class ProductoDAO implements DAO<Producto>{

	// atributos_
		private static final String SQL_INSERT = "INSERT INTO PRODUCTOS (codprod,seccion,nombreprod,precio,fecha,importado,paisorigen)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		private static final String SQL_DELETE = "DELETE FROM PRODUCTOS WHERE codprod= ?";
		private static final String SQL_UPDATE = "UPDATE PRODUCTOS SET fecha = ?,"
				+ "importado = ?, nombreprod = ?, paisorigen= ? ,precio= ? , seccion=? WHERE codprod = ?";
		private static final String SQL_READ = "SELECT * FROM PRODUCTOS WHERE codprod = ?";
		private static final String SQL_READALL = "SELECT * FROM PRODUCTOS";

		

		private DataSource origenDatos;

		

		public ProductoDAO(DataSource origenDatos) {
			
			this.origenDatos = origenDatos;
		}

	
	@Override
	public boolean create(Producto c) throws  SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		// con es mi conexion
		
			try {
				con=origenDatos.getConnection();
				ps = con.prepareStatement(SQL_INSERT);
				
				ps.setString(1, c.getCodProd());
				ps.setString(2, c.getSeccion());
				ps.setString(3, c.getNombreProd());
				ps.setDouble(4, c.getPrecio());
				ps.setDate(5, Date.valueOf(c.getFecha()));
				ps.setBoolean(6, c.getImportado());
				ps.setString(7, c.getPais());
				
				ps.executeUpdate();
				con.close();
				return true;
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			return false;
	}

	@Override
	public boolean delete(Object key) {
		PreparedStatement ps=null;
		Connection con=null;// con es mi conexion
		try {
			con=origenDatos.getConnection();
			ps = con.prepareStatement(SQL_DELETE); // utilizo la
															// conexión
			ps.setString(1, key.toString());
			if (ps.executeUpdate() > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(Producto c)  {
		PreparedStatement ps=null;
		Connection con=null;// con es mi conexion

		try {
			con=origenDatos.getConnection();
			ps = con.prepareStatement(SQL_UPDATE);
		
			
			ps.setDate(1, Date.valueOf(c.getFecha()));
			ps.setBoolean(2, c.getImportado());
			ps.setString(3, c.getNombreProd());
			ps.setString(4, c.getPais());
			ps.setDouble(5, c.getPrecio());
			ps.setString(6, c.getSeccion());
			ps.setString(7, c.getCodProd());
			
			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public Producto read(Object key) {
		PreparedStatement ps;
		ResultSet rs;
		Connection con=null;
		Producto s=null;
		try {
			con=origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READ);
			ps.setString(1,  key.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getBoolean(6), rs.getString(7));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}

	@Override
	public List<Producto> readAll() {
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		List<Producto> productos=new ArrayList<Producto>();
		try {
			con=origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				productos.add( new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getBoolean(6), rs.getString(7)));
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productos;
	}


	
	public DataSource getOrigenDatos() {
		return origenDatos;
	}

}
