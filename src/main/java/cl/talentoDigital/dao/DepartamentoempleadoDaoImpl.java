package cl.talentoDigital.dao;

import java.util.ArrayList;

import cl.talentoDigital.modelo.Departamento;
import cl.talentoDigital.modelo.DepartamentoEmpleado;
import cl.talentoDigital.modelo.Empleado;
import cl.talentoDigital.procesaConexion.AdministradorConexion;

public class DepartamentoempleadoDaoImpl extends AdministradorConexion implements IDepartamentoEmpleadoDao {

	public DepartamentoempleadoDaoImpl() {
		con=generaConexionSingleton();
	}
	
	@Override
	public ArrayList<DepartamentoEmpleado> findAll() {
		ArrayList<DepartamentoEmpleado> depEmpleados =new ArrayList<DepartamentoEmpleado>();
		String sql ="select * from empleado e inner join departamento d on e.numdepto = d.numdepto order by e.numempleado desc";

		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();// es executeQuery(), porque es una consulta (no altera datos)
			while(rs.next()) {
				//int numDepto, String nomDepto, String ubicacionDepto
				Departamento depto = new Departamento(rs.getInt("numdepto"),rs.getString("nomdepto"),rs.getString("ubicaciondpto"));
				//int numEmpleado, String nombre, int numDepto
				Empleado empl=new Empleado(rs.getInt("numempleado"), rs.getString("nombre"),rs.getInt("numdepto"));
				DepartamentoEmpleado depEmpl =new DepartamentoEmpleado(depto, empl);			
				depEmpleados.add(depEmpl);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return depEmpleados;
	}

}
