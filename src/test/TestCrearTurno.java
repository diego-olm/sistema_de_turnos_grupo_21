package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Servicio;

import datos.Usuario;
import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestCrearTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM personaABM = PersonaABM.getInstance();
		ServicioABM servicioABM = ServicioABM.getInstance();
		TurnoABM turnoAbm = TurnoABM.getInstance();
		try {
			//traer servicio
			Servicio servicio =servicioABM.traerServicio(2);
	        LocalDate fecha = LocalDate.of(2024, 10, 15); 
	        //traer usuarios
	        Usuario us1= personaABM.traerUsuario(1);
	        Usuario us2= personaABM.traerUsuario(2);
	        Usuario us3= personaABM.traerUsuario(3);
	        Usuario us4= personaABM.traerUsuario(4);
	        //horas
	        LocalTime hora1 = LocalTime.of(9, 0);   
	        LocalTime hora2 = LocalTime.of(9, 30);  
	        LocalTime hora3 = LocalTime.of(10, 0);  
	        LocalTime hora4 = LocalTime.of(10, 30); 
	        LocalTime hora5 = LocalTime.of(11, 0);  
	     

	      
	         

	        turnoAbm.agregar(fecha, hora1, true, us1, servicio);
	        turnoAbm.agregar(fecha, hora2, true, us2, servicio);
	        turnoAbm.agregar(fecha, hora3, true, us3, servicio);
	        turnoAbm.agregar(fecha, hora4, true, us4, servicio);
	        turnoAbm.agregar(fecha, hora5, true, us1, servicio);
	        

	     // turnoAbm.agregar(turno1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
