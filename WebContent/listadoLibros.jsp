<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.LibroDTO"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="2" align="center" with="75%">
			<tr>

				<td>Busqueda</td>
				<td><select name='cbo_autor' style='width: 150px'>
						<option value="1">Seleccione</option>
						<option value="2">Francisco Herrera</option>
						<option value="3" selected>Luis Caripo</option>
						<option value="4">Gerardo Tipismana</option>
				</select></td>

				<td>Fecha:</td>
				<td><input type='date' name='txt_fecha' required></td>

				<td colspan='2' align='right'><input type='submit'
					value='Consultar' class='boton2'></td>
			</tr>
		</table>

	</div>


	<table border="2" align="center" with="75%">
		<tr>
			<th>COD LIBRO</th>
			<th>NOM AUTOR</th>
			<th>FCH PUBLICACION</th>
			<th>TITULO</th>
			<th>EDITORIAL</th>
			<th>ACCIONES</th>
		</tr>
		<%
			ArrayList<LibroDTO> lista = (ArrayList<LibroDTO>) request.getAttribute("data");
		if (lista != null) {
			for (LibroDTO xLib : lista) {
				out.println("<tr>");
				out.println("<td>" + xLib.getCodigo() + "</td>");
				out.println("<td>" + xLib.getAutor() + "</td>");
				out.println("<td>" + xLib.getFechapublicacion() + "</td>");
				out.println("<td>" + xLib.getTitulo() + "</td>");
				out.println("<td>" + xLib.getEditorial() + "</td>");
				out.println("<td align='center'><a href='ServletLibro?tipo=buscar&cod=" + xLib.getCodigo() + "'>"
				+ "<img src='img/buscar.png' title='Eliminar'></a></td>");
				out.println("</tr>");

			}
		}
		%>

	</table>
</body>
</html>