<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_InsertaUsuario" method="get">
		<table>
			<tr>
				<td width="13%"><label for="nombre">Nombre:</label></td>
				<td width="87%"><input type="text" name="txtNombre" id="nombre"/></td>
			</tr>
			
			<tr>
				<td><label for="apellido">Apellido:</label></td>
				<td><input type="text" name="txtApellidos" id="apellido"/></td>
			</tr>
			
			<tr>
				<td><label for="usuario">Usuario:</label></td>
				<td><input type="text" name="txtUsuario" id="usuario"/></td>
			</tr>
			
			<tr>
				<td><label for="contra">Contraseña:</label></td>
				<td><input type="text" name="txtContrasena" id="contra"/></td>
			</tr>
			
			<tr>
				<td><label for="pais">Pais:</label></td>
				<td><input type="text" name="txtPais" id="pais"/></td>
			</tr>
			
			<tr>
				<td><label for="tecnologia">Tecnologia:</label></td>
				<td><input type="text" name="txtTecnologia" id="tecnologia"/></td>
			</tr>
			</table>
		<p><input type="submit" name="enviar" value="enviar"></input></p>
	</form>
</body>
</html>