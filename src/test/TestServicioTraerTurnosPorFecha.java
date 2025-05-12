package test;

import java.time.LocalDate;

import datos.Servicio;
import negocio.ServicioABM;

public class TestServicioTraerTurnosPorFecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicioABM servicioAbm = ServicioABM.getInstance();
		Servicio servicio = servicioAbm.traerServicioYTurnoPorFecha(2,  LocalDate.of(2024, 10, 15));
		System.out.println(servicio.toString());
		System.out.println(servicio.getTurnos());
	}

}
