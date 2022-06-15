package cl.talentoDigital.dao;

import java.sql.SQLException;

import cl.talentoDigital.modelo.Empleado;
import cl.talentoDigital.procesaConexion.AdministradorConexion;

public class EmpleadoDaoImpl extends AdministradorConexion implements IEmpleadoDao {
	
	public EmpleadoDaoImpl() {
		con= generaConexionSingleton();
	}

	//add() inserta empleado a la tabla empleado y retorna un true si la inserción fue exitosa
	@Override
	public boolean add(Empleado empleado) {
		if(con==null) {
			return false;
		}
		
		String sql ="INSERT INTO EMPLEADO VALUES (EMPL_SEC.NEXTVAL,'"+empleado.getNombre()+"',"+empleado.getNumDepto()+")";
		
		try {
			
			ps=con.prepareStatement(sql);
			int resultado= ps.executeUpdate();	//	executeUpdate porque estamos alterando registros de la BD
			if(resultado==1) {//executeUpdate() retorna 1 si se logró insertar el registro a la tabla
				return true; //retorno true avisando que se insertó el registro
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Empleado update(Empleado empleado) {
		String sql ="UPDATE EMPLEADO SET NOMBRE='"+empleado.getNombre()+"', NUMDEPTO="+empleado.getNumDepto()+" WHERE NUMEMPLEADO="+empleado.getNumEmpleado();
		
		try {
			
			ps=con.prepareStatement(sql);
			int resultado= ps.executeUpdate();		
			if(resultado==1) {
				return empleado;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Empleado();
	}

	@Override
	public boolean delete(int numEmp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado findById(int numEmpl) {
		String sql ="select * from empleado where numempleado="+numEmpl;
	try {
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();	
			if(rs.next()) {
				//int numEmpleado, String nombre, int numDepto
				Empleado empleado = new Empleado(rs.getInt("numempleado"),rs.getString("nombre"),rs.getInt("numdepto"));
				return empleado;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Empleado();
	}

}
