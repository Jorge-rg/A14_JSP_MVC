<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_LoginUsuario" method="get">
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
		<p><input type="submit" name="enviar" value="enviar"></input></p>
	</form>
</body>
</html>