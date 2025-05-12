package test;

import negocio.PersonaABM;

public class TestUsuarioCrearUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonaABM personaAbm = PersonaABM.getInstance();
		try {
			personaAbm.registrarUsuario("Carlos", "P�rez", "carlos.p@mail.com", 27456321L, 1165432109L, "C�rdoba",
					"cperez22");
			personaAbm.registrarUsuario("Mar�a", "Gonz�lez", "maria.g@mail.com", 33456789L, 1156789012L, "Buenos Aires",
					"mariagonz");
			personaAbm.registrarUsuario("Luc�a", "Rodr�guez", "lucia.r@mail.com", 35432876L, 1178901234L, "Mendoza",
					"lrodriguez");
			personaAbm.registrarUsuario("Juan", "Mart�nez", "juan.m@mail.com", 28456789L, 1187654321L, "Rosario",
					"juanmart");
			personaAbm.registrarUsuario("Ana", "L�pez", "ana.l@mail.com", 36458901L, 1198765432L, "Mar del Plata",
					"analopez");
			System.out.println(personaAbm.traerUsuarios());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
