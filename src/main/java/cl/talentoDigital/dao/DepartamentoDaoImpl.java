package cl.talentoDigital.dao;

import java.util.ArrayList;

import cl.talentoDigital.modelo.Departamento;
import cl.talentoDigital.procesaConexion.AdministradorConexion;

public class DepartamentoDaoImpl extends AdministradorConexion implements IDepartamentoDao {

	@Override
	public ArrayList<Departamento> findAll() {
		ArrayList<Departamento> departamentos= new ArrayList<Departamento>();
		String sql ="select * from departamento";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();// es executeQuery(), porque es una consulta (no altera datos)
			while(rs.next()) {
				//int numDepto, String nomDepto, String ubicacionDepto
				Departamento depto = new Departamento(rs.getInt("numdepto"),rs.getString("nomdepto"),rs.getString("ubicaciondpto"));
				departamentos.add(depto);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return departamentos;
	}

}
