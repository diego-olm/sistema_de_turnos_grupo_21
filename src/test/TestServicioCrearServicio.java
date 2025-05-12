package test;

import java.time.LocalTime;


import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestServicioCrearServicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM personaAbm = PersonaABM.getInstance();
		ServicioABM servicioAbm = ServicioABM.getInstance();
		int traumatologiaId = servicioAbm.crearServicio("Traumatología", LocalTime.of(8, 0), LocalTime.of(13, 0), 20);
		int ecocardiogramasId = servicioAbm.crearServicio("Ecocardiogramas", LocalTime.of(9, 0), LocalTime.of(17, 0),
				30);
		int endoscopiasId = servicioAbm.crearServicio("Endoscopías Digestivas", LocalTime.of(7, 30),
				LocalTime.of(12, 30), 45);

		servicioAbm.crearServicio("Toma de Muestras Biológicas", LocalTime.of(7, 0), LocalTime.of(14, 0), 15);
		servicioAbm.crearServicio("Puesto de Vacunación", LocalTime.of(8, 0), LocalTime.of(18, 0), 10);
		
		Servicio traumatologia = servicioAbm.traerServicio(traumatologiaId);
		Servicio ecocardiogramas = servicioAbm.traerServicio(ecocardiogramasId);
		Servicio endoscopias = servicioAbm.traerServicio(endoscopiasId);
		try {
			personaAbm.registrarEmpleado("Carlos", "Gómez", "c.gomez@hospital.com", 33456789L, 1156781234L,
					"CABA", "LEG-TRAU-2023", 
					traumatologia 
			);
			personaAbm.registrarEmpleado("Ana", "Pérez", "a.perez@hospital.com", 35123456L, 1167894321L, "GBA Norte",
					"LEG-CARD-2023", ecocardiogramas);
			personaAbm.registrarEmpleado("Luis", "Martínez", "l.martinez@hospital.com", 28976543L, 1145678901L,
					"GBA Sur", "LEG-GAST-2023", endoscopias);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
