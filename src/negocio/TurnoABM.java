package negocio;

import java.util.List;

import dao.TurnoDao;
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
	public int agregar(Turno objeto) {
		return TurnoDao.getInstance().agregar(objeto);
	}
}
