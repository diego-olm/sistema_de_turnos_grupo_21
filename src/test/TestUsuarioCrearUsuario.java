package test;

import negocio.PersonaABM;

public class TestUsuarioCrearUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonaABM personaAbm = PersonaABM.getInstance();
		try {
			personaAbm.registrarUsuario("Carlos", "Pérez", "carlos.p@mail.com", 27456321L, 1165432109L, "Córdoba",
					"cperez22");
			personaAbm.registrarUsuario("María", "González", "maria.g@mail.com", 33456789L, 1156789012L, "Buenos Aires",
					"mariagonz");
			personaAbm.registrarUsuario("Lucía", "Rodríguez", "lucia.r@mail.com", 35432876L, 1178901234L, "Mendoza",
					"lrodriguez");
			personaAbm.registrarUsuario("Juan", "Martínez", "juan.m@mail.com", 28456789L, 1187654321L, "Rosario",
					"juanmart");
			personaAbm.registrarUsuario("Ana", "López", "ana.l@mail.com", 36458901L, 1198765432L, "Mar del Plata",
					"analopez");
			System.out.println(personaAbm.traerUsuarios());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
