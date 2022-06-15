package cl.talentoDigital.modelo;

public class Departamento {
	private int numDepto;
	private String nomDepto;
	private String ubicacionDepto;
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Departamento(int numDepto, String nomDepto, String ubicacionDepto) {
		super();
		this.numDepto = numDepto;
		this.nomDepto = nomDepto;
		this.ubicacionDepto = ubicacionDepto;
	}

	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}

	public String getNomDepto() {
		return nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public String getUbicacionDepto() {
		return ubicacionDepto;
	}

	public void setUbicacionDepto(String ubicacionDepto) {
		this.ubicacionDepto = ubicacionDepto;
	}

	@Override
	public String toString() {
		return "Departamento [numDepto=" + numDepto + ", nomDepto=" + nomDepto + ", ubicacionDepto=" + ubicacionDepto
				+ "]";
	}
	
	
}
