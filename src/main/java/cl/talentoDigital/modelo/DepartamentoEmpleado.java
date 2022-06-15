package cl.talentoDigital.modelo;

//esta clase de tipo objeto representa la relación entre empleado y el departamento al cuál pertenece
public class DepartamentoEmpleado {
	
	private Departamento departamento;
	private Empleado empleado;
	
	public DepartamentoEmpleado() {
		// TODO Auto-generated constructor stub
	}

	public DepartamentoEmpleado(Departamento departamento, Empleado empleado) {
		super();
		this.departamento = departamento;
		this.empleado = empleado;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "DepartamentoEmpleado [departamento=" + departamento + ", empleado=" + empleado + "]";
	}
	
	

}
