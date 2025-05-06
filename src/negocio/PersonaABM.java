package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Persona;
import datos.Usuario;

public class PersonaABM {
	private static PersonaABM instancia = null;

	protected PersonaABM() {
	}

	public static PersonaABM getInstance() {
		if (instancia == null)
			instancia = new PersonaABM();
		return instancia;
	}

	public Persona traerUsuario(long personaId) {
		// TODO: terminar la validación de datos
		return PersonaDao.getInstance().traer(personaId);
	}

	public List<Persona> traerUsuarios() {
		// TODO: terminar la validación de datos
		return PersonaDao.getInstance().traer();
	}
	public int registrarUsuario(String nombre, String apellido, String email, long dni, long telefono, String localidad,String nombreUsuario) {
	Persona usuario = new Usuario(nombre,apellido,email,dni,telefono,localidad,nombreUsuario);
	// TODO: terminar la validación de datos
	return PersonaDao.getInstance().agregar(usuario);
	}
	public Persona traerPersonaEmail(String email) {
		
		Persona objeto= PersonaDao.getInstance().traerEmail(email);
		if(objeto!=null) {
			System.out.println("Persona con email ya existe");
		}
		return objeto;
	}
	public void eliminarUsuario(long usuarioId) {
		// TODO: terminar la validación de datos
		Persona usuario = PersonaDao.getInstance().traer(usuarioId);
		if(usuario instanceof Usuario) {
			PersonaDao.getInstance().agregar(usuario);
		}
		
	}
	public void actualizar(Persona objeto) {
		// TODO: terminar la validación de datos
		PersonaDao.getInstance().actualizar(objeto);
	}
	public Persona traerUsuarioYTurnos(long personaId) {
		Persona usuario = PersonaDao.getInstance().traer(personaId);
		if(usuario instanceof Usuario ) {
			usuario = PersonaDao.getInstance().traerUsuarioYTurnos(personaId);
		}
		return usuario;
	}
}
