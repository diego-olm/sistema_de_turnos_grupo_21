package datos;

public class Empleado extends Persona {
	private long empleadoId;
	private String legajo;
	private Servicio servicio;

	public Empleado() {
		super();

	}

	public Empleado(String nombre, String apellido, String email, long dni, long telefono, String localidad,
			String legajo, Servicio servicio) {
		super(nombre, apellido, email, dni, telefono, localidad);

		this.legajo = legajo;
		this.servicio = servicio;
	}

	public long getEmpleadoId() {
		return empleadoId;
	}

	protected void setEmpleadoId(long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (empleadoId ^ (empleadoId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (empleadoId != other.empleadoId)
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format(
	        "Empleado {\n" +
	        "   Nombre: %s %s\n" +
	        "   Contacto: %s | Tel: %d\n" +
	        "   DNI: %d | Localidad: %s\n" +
	        "   ID: %d | Legajo: %s\n" +
	        "}\n",  
	        nombre, apellido, email, telefono, dni, localidad, personaId, legajo
	    );
	}
}
