package cl.talentoDigital.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentoDigital.dao.DepartamentoDaoImpl;
import cl.talentoDigital.dao.EmpleadoDaoImpl;
import cl.talentoDigital.dao.IDepartamentoDao;
import cl.talentoDigital.dao.IEmpleadoDao;
import cl.talentoDigital.modelo.Departamento;
import cl.talentoDigital.modelo.Empleado;


@WebServlet("/agregarEmpleado")
public class AgregarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDepartamentoDao dao= new DepartamentoDaoImpl();
		ArrayList<Departamento> departamentos =dao.findAll();
		request.setAttribute("departamentosAtt",departamentos);
		
		request.getRequestDispatcher("formularioAgregarEmpleado.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IEmpleadoDao dao = new EmpleadoDaoImpl();
		 String nombre=request.getParameter("nombre");
		 String numDepto=request.getParameter("numeroDepto");
		 //int numEmpleado, String nombre, int numDepto
		 Empleado empleado= new Empleado(0,nombre,Integer.parseInt(numDepto));
		 boolean usuarioAgregado = dao.add(empleado);
		 if(usuarioAgregado) {
			 request.getRequestDispatcher("procesaInicio").forward(request, response);
		 }
		 else {
			 request.getRequestDispatcher("404.html").forward(request, response);
		 }
	}

}
