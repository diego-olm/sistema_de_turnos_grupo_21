package test;

import datos.Usuario;
import negocio.PersonaABM;

public class TestUsuarioTraerConTurnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = PersonaABM.getInstance().traerUsuarioYTurnos(1);
		System.out.println(usuario.toString());
		System.out.println(usuario.getTurnos());
	}

}
