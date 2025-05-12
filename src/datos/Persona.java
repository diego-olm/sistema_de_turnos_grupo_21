package datos;

public abstract class Persona {

	protected long personaId;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected long dni;
	protected long telefono;
	protected String localidad;

	public Persona() {

	}

	public Persona(String nombre, String apellido, String email, long dni, long telefono, String localidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.telefono = telefono;
		this.localidad = localidad;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getPersonaId() {
		return personaId;
	}

	protected void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Persona [personaId=" + personaId + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", dni=" + dni + ", telefono=" + telefono + ", localidad=" + localidad + "]";
	}

}
