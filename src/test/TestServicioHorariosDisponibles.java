package test;

import java.time.LocalDate;

import negocio.ServicioABM;

public class TestServicioHorariosDisponibles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServicioABM servicioAbm= ServicioABM.getInstance();
		System.out.println(servicioAbm.traerServicioHorariosDisponiblesFecha(1,  LocalDate.of(2024, 10, 15)));
	}

}
