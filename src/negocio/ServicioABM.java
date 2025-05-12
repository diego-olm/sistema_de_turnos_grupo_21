package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.ServicioDao;
import datos.Servicio;
import datos.Turno;

public class ServicioABM {
	private static ServicioABM instancia = null;

	protected ServicioABM() {
	}

	public static ServicioABM getInstance() {
		if (instancia == null)
			instancia = new ServicioABM();
		return instancia;
	}
	
	public int crearServicio(String nombre,LocalTime horaInicio,LocalTime horaFin,int  intervalo) {
		Servicio objeto = new Servicio(nombre, horaInicio, horaFin, intervalo);
		
		return ServicioDao.getInstance().agregar(objeto);
	}
	public void eliminarServicio(int servicioId) {
		Servicio objeto = ServicioDao.getInstance().traer(servicioId);
		ServicioDao.getInstance().eliminar(objeto);
	}
	public void actualizarServicio(Servicio objeto ) {
		
		ServicioDao.getInstance().actualizar(objeto);
	}
	public Servicio traerServicio(long servicioId) {
		return ServicioDao.getInstance().traer(servicioId);
	}
	public Servicio traerServicioYEmpleado(long servicioId) {
		return ServicioDao.getInstance().traerServicioYEmpleado(servicioId);
	}
	
	public List<Servicio> traerServicios(){
		return ServicioDao.getInstance().traer();
	}
	 public List<LocalTime> calcularHorarios(Servicio objeto) {
		    Servicio servicio= objeto;
	        List<LocalTime> horarios = new ArrayList<>();
	        LocalTime fin = servicio.getHoraFin();
	        int intervaloMinutos = servicio.getIntervalo();
	        LocalTime tiempoActual =servicio.getHoraInicio();
	        
	        while (!tiempoActual.isAfter(fin)) {
	            horarios.add(tiempoActual);
	            tiempoActual = tiempoActual.plusMinutes(intervaloMinutos);
	        }
	        
	        return horarios;
	    }
	 public Servicio traerServicioYTurno(long servicioId){
		 
		 return ServicioDao.getInstance().traerServicioYTurnos(servicioId);
	 }

	public Servicio traerServicioYTurnoPorFecha(long servicioId, LocalDate fecha) {
		 
		 
		 return ServicioDao.getInstance().traerServicioYTurnosPorFecha(servicioId, fecha);
	 }
	public List<LocalTime> traerServicioHorariosDisponiblesFecha(long servicioId, LocalDate fecha){
		Servicio servicio = ServicioDao.getInstance().traerServicioYTurnosPorFecha(servicioId, fecha);
		
		List<LocalTime> listHorarios = calcularHorarios(servicio);
		for (Turno i : servicio.getTurnos()) {
			listHorarios.remove(i.getHora());
		}
		return listHorarios;
	}
}
