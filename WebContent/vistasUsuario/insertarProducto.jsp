<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_InsertaProducto" method="get">
		<table>
			<tr>
				<td width="13%"><label for="codigo">Codigo producto:</label></td>
				<td width="87%"><input type="text" name="txtCod" id="codigo"/></td>
			</tr>
			<tr>
				<td width="13%"><label for="nombre">Fecha:</label></td>
				<td width="87%"><input type="text" name="txtFecha" id="fecha"/></td>
			</tr>
			
			<tr>
				<td><label for="apellido">Importado:</label></td>
				<td><input type="text" name="txtImportado" id="importado"/></td>
			</tr>
			
			<tr>
				<td><label for="usuario">Nombre Producto:</label></td>
				<td><input type="text" name="txtNom" id="usuario"/></td>
			</tr>
			
			<tr>
				<td><label for="pais">Pais:</label></td>
				<td><input type="text" name="txtPais" id="pais"/></td>
			</tr>
			
			<tr>
				<td><label for="tecnologia">Precio:</label></td>
				<td><input type="text" name="txtPrecio" id="precio"/></td>
			</tr>
			
			<tr>
				<td><label for="tecnologia">Seccion:</label></td>
				<td><input type="text" name="txtSeccion" id="seccion"/></td>
			</tr>
			</table>
		<p><input type="submit" name="enviar" value="enviar"></input></p>
	</form>
</body>
</html>