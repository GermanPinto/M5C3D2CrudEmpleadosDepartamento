<%@page import="cl.talentoDigital.modelo.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.talentoDigital.modelo.Empleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Agregar Empleado</title>
</head>
<%

Empleado empleado = (Empleado)request.getAttribute("empleadoAtt");
ArrayList<Departamento> departamentos= (ArrayList<Departamento>)request.getAttribute("departamentosAtt");

%>
<body>
	<div class="container">
		<form action="modificarEmpleado" method="POST">
		<input name="numEmpl"  type="hidden" class="form-control" value="<%=empleado.getNumEmpleado()%>">
					<div class="mt-5">
						<h4>Modificar Empleado</h4>
					</div>
					<div >
						<div class="form-group">
							<label>Nombre</label> 
							<input name="nombre" id="nombreAdd" type="text" class="form-control" value="<%=empleado.getNombre()%>">
						</div>
						
						<div class="form-group">
							<label>Numero Departamento</label>
							 <select name="numeroDepto" class="form-select">
							<%
							for(Departamento departamento: departamentos){
							 %>
							<option value="<%=departamento.getNumDepto()%>">
								<%=departamento.getNomDepto()%>
							</option>
							<%
							}
							%>
						</div>

					</div>
					<div class="mt-5" >
						<input type="submit"class="btn btn-success" value="Modificar">
					</div>
				</form>
	</div>
</body>
</html>