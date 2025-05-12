package datos;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Servicio {
	private long servicioId;
	private String nombre;
	private Empleado empleado;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private int intervalo;
	private Set<Turno> turnos;
	private boolean estado;

	public Servicio() {

	}

	public Servicio(String nombre, Empleado empleado, LocalTime horaInicio, LocalTime horaFin, int intervalo) {
		super();
		this.nombre = nombre;
		this.empleado = empleado;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.intervalo = intervalo;
		this.turnos = new HashSet<>();
		this.estado = true;
	}

	public Servicio(String nombre, LocalTime horaInicio, LocalTime horaFin, int intervalo) {
		super();
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.intervalo = intervalo;
		this.estado = true;
		this.turnos = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getServicioId() {
		return servicioId;
	}

	public void setServicioId(long servicioId) {
		this.servicioId = servicioId;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (servicioId ^ (servicioId >>> 32));
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
		Servicio other = (Servicio) obj;
		if (servicioId != other.servicioId)
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format(
	        "Servicio {\n" +
	        "  ID: %d\n" +
	        "  Nombre: %s\n" +
	        "  Horario: %s a %s\n" +
	        "  Intervalo: %d minutos\n" +
	        "  Estado: %s\n" +
	        "}\n",
	        servicioId, 
	        nombre, 
	        horaInicio, 
	        horaFin, 
	        intervalo,
	        estado ? "Activo" : "Inactivo"
	    );
	}

}
