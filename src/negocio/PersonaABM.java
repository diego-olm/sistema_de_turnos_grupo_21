package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import datos.Empleado;
import datos.Persona;
import datos.Servicio;
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

	public Usuario traerUsuario(long personaId) throws Exception {
		// TODO: terminar la validación de datos
		Persona usuario= PersonaDao.getInstance().traer(personaId);
		if(usuario == null || !(usuario instanceof Usuario)) {
			throw new Exception ("No es un usuario");

		}
		return (Usuario) usuario;
	}

	public List<Persona> traerUsuarios() {
		// TODO: terminar la validación de datos
		return PersonaDao.getInstance().traer();
	}

	public int registrarUsuario(String nombre, String apellido, String email, long dni, long telefono, String localidad,
			String nombreUsuario) throws Exception {
		if ( PersonaDao.getInstance().traerEmail(email)!=null) {
			throw new Exception ( "Ya existe un usuario registrado con el Email : "+ email );
		}
		
		Persona usuario = new Usuario(nombre, apellido, email, dni, telefono, localidad, nombreUsuario);
		 
		return PersonaDao.getInstance().agregar(usuario);
	}

	public Persona traerPersonaEmail(String email)throws Exception {

		Persona objeto = PersonaDao.getInstance().traerEmail(email);
		return objeto;
	}

	public void eliminarUsuario(long usuarioId) {
		
		Persona usuario = PersonaDao.getInstance().traer(usuarioId);
		if (usuario instanceof Usuario) {
			PersonaDao.getInstance().agregar(usuario);
		}

	}

	public void actualizar(Persona objeto) {
		// TODO: terminar la validación de datos
		PersonaDao.getInstance().actualizar(objeto);
	}

	public Usuario traerUsuarioYTurnos(long personaId) {
		Persona usuario = PersonaDao.getInstance().traer(personaId);
		if (usuario instanceof Usuario) {
			usuario = PersonaDao.getInstance().traerUsuarioYTurnos(personaId);
		}
		return (Usuario) usuario;
	}

	public Empleado traerEmpleado(long empleadoId) throws Exception {
		// TODO: terminar la validación de datos
		Persona empleado = PersonaDao.getInstance().traer(empleadoId);
		if(empleado!=null || !(empleado instanceof Empleado)) {
			throw new Exception ( "no es un empleado ");

		}
		return (Empleado) empleado;
	}

	public List<Empleado> traerEmpleados() {
		
		List<Persona> personas = PersonaDao.getInstance().traer();
		List<Empleado> empleados = new ArrayList<>();
		 for (Persona persona : personas) {
	            if (persona instanceof Empleado) {
	                empleados.add((Empleado) persona);
	            }
	        }
		return empleados;
	}

	public int registrarEmpleado(String nombre, String apellido, String email, long dni, long telefono,
			String localidad, String legajo, Servicio servicio) throws Exception {
		if ( PersonaDao.getInstance().traerEmail(email)!=null) {
			throw new Exception ( "Ya existe un Empleado registrado con el Email : "+ email );
		}
		
		Persona empleado = new Empleado(nombre, apellido, email, dni, telefono, localidad, legajo, servicio);
		
		return PersonaDao.getInstance().agregar(empleado);
	}
}
