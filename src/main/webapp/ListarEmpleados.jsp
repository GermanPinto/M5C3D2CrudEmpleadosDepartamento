<%@page import="cl.talentoDigital.modelo.DepartamentoEmpleado"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Ejemplo Prueba v0</title>
</head>
<%
ArrayList<DepartamentoEmpleado> lista =(ArrayList<DepartamentoEmpleado>) request.getAttribute("depEmpleadosAtt");

%>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>Empleados con su Departamento</h1>
		<p>Para el bootcamp</p>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand ms-5" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">menu1</a></li>
				<li class="nav-item"><a class="nav-link" href="#">menu2</a></li>
				<li class="nav-item"><a class="nav-link" href="#">menu3</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="margin-top: 30px">

<a class="btn btn-primary" href="agregarEmpleado">Agregar empleado</a>
<!-- Forma para crud -->

		<form  method="post">

		<div class="col-sm-9">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Numero Empleado</th>
		      <th scope="col">Nombre Empleado</th>
		      <th scope="col">Nombre Departamento</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  <%
		  	for(DepartamentoEmpleado elemento:lista){
		  %>
		    <tr>
		      <td><%=elemento.getEmpleado().getNumEmpleado() %></td>
		      <td><%= elemento.getEmpleado().getNombre() %></td>
		      <td><%= elemento.getDepartamento().getNomDepto() %></td>
		      <td>
			      <a class="btn btn-primary" href="modificarEmpleado?idEmpleadoSeleccionado=<%=elemento.getEmpleado().getNumEmpleado()%>">Modificar</a>
			      <a class="btn btn-secondary" href="eliminarEmpleado?idEmpleadoSeleccionado=<%=elemento.getEmpleado().getNumEmpleado()%>">Eliminar</a>
		      </td>
		    </tr>
		    <%
		  	}
		    %>
		  </tbody>
		</table>
		
		</div>
		</form>


	</div>




	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>