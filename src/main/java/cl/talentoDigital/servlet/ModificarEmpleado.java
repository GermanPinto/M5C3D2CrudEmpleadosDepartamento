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

/**
 * Servlet implementation class ModificarEmpleado
 */
@WebServlet("/modificarEmpleado")
public class ModificarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numEmpl= Integer.parseInt(request.getParameter("idEmpleadoSeleccionado"));
		 IEmpleadoDao empDao = new EmpleadoDaoImpl();
		 Empleado empleado = empDao.findById(numEmpl);
		 
		 IDepartamentoDao depDao= new DepartamentoDaoImpl();
		 ArrayList<Departamento> departamentos =depDao.findAll();
		 request.setAttribute("departamentosAtt",departamentos);
		
		request.setAttribute("empleadoAtt", empleado);
		
		request.getRequestDispatcher("formularioActualizarEmpleado.jsp").forward(request, response);
	}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IEmpleadoDao dao = new EmpleadoDaoImpl();
		 String numEmpl= request.getParameter("numEmpl");
		 String nombre=request.getParameter("nombre");
		 String numDepto=request.getParameter("numeroDepto");
		 
		 Empleado empleado = new Empleado(Integer.parseInt(numEmpl),nombre,Integer.parseInt(numDepto));
		 
		 Empleado empleadoRetornado = dao.update(empleado);
		 
		 if(empleadoRetornado!=null) {
			 request.getRequestDispatcher("procesaInicio").forward(request, response);
		 }
		 else {
			 request.getRequestDispatcher("404.html").forward(request, response);
		 }
		 
		}

}
