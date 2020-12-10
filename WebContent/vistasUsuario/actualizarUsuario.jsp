<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_ActualizarUsuario" method="get">
		<table>
			<tr>
				<td width="13%"><label for="usuario">Usuario:</label></td>
				<td width="87%"><input type="text" name="txtUsuario" id="usuario"/></td>
			</tr>
			<tr>
				<td width="13%"><label for="contrasena">Contraseña:</label></td>
				<td width="87%"><input type="text" name="txtContra" id="contrasena"/></td>
			</tr>
			</table>
		<p><input type="submit" name="buscar" value="buscar"></input></p>
	
	<c:set />
	
		<table>
			<tr>
				<td width="13%"><label for="id">ID:</label></td>
				<td width="87%"><input type="text" name="txtIdEn" id="id"/></td>
			</tr>
			<tr>
				<td width="13%"><label for="nombre">Nombre:</label></td>
				<td width="87%"><input type="text" name="txtNombreEn" id="nombre"/></td>
			</tr>
			
			<tr>
				<td><label for="apellido">Apellido:</label></td>
				<td><input type="text" name="txtApellidosEn" id="apellido"/></td>
			</tr>
			
			<tr>
				<td><label for="usuario">Usuario:</label></td>
				<td><input type="text" name="txtUsuarioEn" id="usuario"/></td>
			</tr>
			
			<tr>
				<td><label for="contra">Contraseña:</label></td>
				<td><input type="text" name="txtContrasenaEn" id="contra"/></td>
			</tr>
			
			<tr>
				<td><label for="pais">Pais:</label></td>
				<td><input type="text" name="txtPaisEn" id="pais"/></td>
			</tr>
			
			<tr>
				<td><label for="tecnologia">Tecnologia:</label></td>
				<td><input type="text" name="txtTecnologiaEn" id="tecnologia"/></td>
			</tr>
			</table>
		<p><input type="submit" name="enviar" value="enviar"></input></p>
	</form>
</body>
</html>