<%@page import="java.util.ArrayList"%>
<%@page import="beans.LibroDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#frmeliminar").validate();
	});
</script>
</head>
<body>
	<form action="ServletLibro?tipo=eliminar" id="frmeliminar"
		method="post">
		<%
			LibroDTO xLib = (LibroDTO) request.getAttribute("Libro");
		out.println("<table align='center'>");
		out.println("<tr>");
		out.println("<td>Codigo</td>");
		out.println("<td><input type='text' name='txt_cod' class='required' value='"+xLib.getCodigo() + "'></td>");
	
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Autor</td>");	
		out.println("<td><input type='text' name='txt_aut' class='required' value='"+xLib.getAutor()+"'>");

		out.println("</td>");
		out.println("</tr>");%>
		<tr>
			<td>Libro</td>
			<td><input type='text' name='txt_tit' class='required' value='<%=xLib.getTitulo()%>'></td>
		</tr>
		<tr>
			<td>Publicacion:</td>
			<td><input type='date' name='txt_fecha' required value='<%=xLib.getFechapublicacion() %>'></td>
		</tr>
		<tr>
			<td>Autor</td>
			<td><select name='cbo_autor' style='width: 150px'>
					<option value="1">Francisco Herrera</option>
					<option value="2" selected>Luis Caripo</option>
					<option value="3">Gerardo Tipismana</option>
			</select></td>
		</tr>
		<tr>
			<td>Género</td>
			<td><select name='cbo_genero' style='width: 150px'>
					<option value='1'>Programacion</option>
					<option value='2'>Literatura</option>
			</select></td>
		</tr>
		<tr>
			<td colspan='2' align='right'><input type='submit'
				value='Eliminar' class='boton2'></td>
		</tr>
		</table>
	</form>
</body>
</html>