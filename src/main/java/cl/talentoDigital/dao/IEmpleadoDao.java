package cl.talentoDigital.dao;

import cl.talentoDigital.modelo.Empleado;

public interface IEmpleadoDao {

	public boolean add(Empleado empleado);
	public Empleado update(Empleado empleado);
	public boolean delete(int numEmp);
	public Empleado findById(int numEmpl);
}
