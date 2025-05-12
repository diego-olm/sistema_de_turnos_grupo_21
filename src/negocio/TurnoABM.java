package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Servicio;
import datos.Turno;
import datos.Usuario;

public class TurnoABM {
	private static TurnoABM instancia = null;

	protected TurnoABM() {
	}

	public static TurnoABM getInstance() {
		if (instancia == null)
			instancia = new TurnoABM();
		return instancia;
	}
	
	public Turno traer(long turnoId) {
		return TurnoDao.getInstance().traer(turnoId);
	}
	public List<Turno> traer(Usuario u){
		return TurnoDao.getInstance().traer(u);
	}
	public int agregar(LocalDate fecha, LocalTime hora, boolean estado, Usuario usuario, Servicio servicio) {
		Turno objeto = new Turno(fecha, hora, estado, usuario, servicio);
		return TurnoDao.getInstance().agregar(objeto);
	}
}
