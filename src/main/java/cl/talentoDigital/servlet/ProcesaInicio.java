package cl.talentoDigital.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.talentoDigital.dao.DepartamentoempleadoDaoImpl;
import cl.talentoDigital.dao.IDepartamentoEmpleadoDao;
import cl.talentoDigital.modelo.DepartamentoEmpleado;


@WebServlet("/procesaInicio")
public class ProcesaInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DepartamentoEmpleado> depEmpleados =new ArrayList<DepartamentoEmpleado>();
		IDepartamentoEmpleadoDao dao = new DepartamentoempleadoDaoImpl();		
		
		depEmpleados =dao.findAll();
		request.setAttribute("depEmpleadosAtt", depEmpleados);
		
		request.getRequestDispatcher("ListarEmpleados.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
