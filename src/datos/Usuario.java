package datos;

import java.util.HashSet;
import java.util.Set;

public class Usuario extends Persona {

	private long usuarioId;
	private String nombreUsuario;
	private Set<Turno> turnos;

	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email, long dni, long telefono, String localidad,
			String nombreUsuario) {
		super(nombre, apellido, email, dni, telefono, localidad);
		this.nombreUsuario = nombreUsuario;
		this.turnos = new HashSet<>();
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + (int) (usuarioId ^ (usuarioId >>> 32));
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
		Usuario other = (Usuario) obj;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format(
	        "USUARIO » %s %s (ID: %d)\n" +
	        "           Usuario: @%s | Email: %s\n" +
	        "           Tel: %d | DNI: %d | %s\n\n",
	        nombre, apellido, personaId, nombreUsuario, email, telefono, dni, localidad
	    );
	}



}
