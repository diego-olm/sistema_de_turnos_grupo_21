package test;

import java.time.LocalDate;
import java.time.LocalTime;


import datos.Turno;
import datos.Usuario;
import negocio.PersonaABM;
import negocio.TurnoABM;


public class TestTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int id = PersonaABM.getInstance().registrarUsuario("María", "González", "maria.gonzalez@example.com", 34567890L, 1156789012L, "Buenos Aires", "mariagonz");
		Usuario usuario= (Usuario) PersonaABM.getInstance().traerUsuario(1);
		//Turno turno1=new Turno(LocalDate.of(2023, 12, 15),LocalTime.of(14, 30),true,usuario);
		Turno turno2 = new Turno(LocalDate.of(2024, 1, 20), LocalTime.of(10, 15), false, usuario);
		TurnoABM.getInstance().agregar(turno2);
		System.out.println(TurnoABM.getInstance().traer(1));
	}

}
