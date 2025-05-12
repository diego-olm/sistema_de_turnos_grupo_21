package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	private long turnoId;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean estado;
	private Usuario usuario;
	private Servicio servicio;

	public Turno() {
	}

	public Turno(LocalDate fecha, LocalTime hora, boolean estado, Usuario usuario, Servicio servicio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.usuario = usuario;
		this.servicio = servicio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public long getTurnoId() {
		return turnoId;
	}

	protected void setTurnoId(long turnoId) {
		this.turnoId = turnoId;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + (int) (turnoId ^ (turnoId >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Turno other = (Turno) obj;
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (turnoId != other.turnoId)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format("Turno{turnoId=%-2d | fecha=%-10s | hora=%-5s | estado=%-5s}",
	                        turnoId, fecha, hora, estado);
	}
}
