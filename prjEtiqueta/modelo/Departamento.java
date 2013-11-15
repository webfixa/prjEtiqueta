package modelo;

public class Departamento {
	
	private String cod;
	private String Dep;
	
	public Departamento(String cod, String dep) {
		super();
		this.cod = cod;
		Dep = dep;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDep() {
		return Dep;
	}

	public void setDep(String dep) {
		Dep = dep;
	}

}
