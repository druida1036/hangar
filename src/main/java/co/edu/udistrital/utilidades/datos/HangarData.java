package co.edu.udistrital.utilidades.datos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udistrital.controladores.servicios.PlanMantenimientoService;
import co.edu.udistrital.modelo.dao.NaveDAO;
import co.edu.udistrital.modelo.entidades.Avion;
import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Helicoptero;
import co.edu.udistrital.modelo.entidades.Nave;
import co.edu.udistrital.modelo.entidades.PlanMantenimiento;
import co.edu.udistrital.modelo.entidades.Tarea;

@Component
public class HangarData {
	@Autowired
	public NaveDAO dao;
	@Autowired
	public PlanMantenimientoService planMantenimientoService;

	public HangarData() {
	}

	@PostConstruct
	public void crearDatos() {
		crearNaves();
		crearPlanes();
	}

	private void crearPlanes() {
		Map<String, String[]> planes = new HashMap<String, String[]>();
		planes.put("plan_01", new String[] { "Mantenimiento Aviones,Mantenimiento Aviones",
				"Revision Combustible,Revision Combustible;Presurizacion,presurizacion" });
		planes.put("plan_02", new String[] { "Mantenimiento General,Mantenimiento General",
				"Manteniento fuselaje,Manteniento fusalaje;Revision Cabina,Revision Cabina" });

		for (Map.Entry<String, String[]> row : planes.entrySet()) {
			String[] datos = row.getValue()[0].split(",");
			crearPlan(datos[0], datos[1], row.getValue()[1]);

		}

	}

	private void crearPlan(String nombre, String descripcion, String datos) {
		String[] tareas = datos.split(";");
		PlanMantenimiento planMantenimiento = new PlanMantenimiento();
		planMantenimiento.setNombre(nombre);
		planMantenimiento.setDescripcion(descripcion);
		for (String registro : tareas) {
			String[] info = registro.split(",");
			crearTarea(planMantenimiento, info[0], info[1]);
		}
		planMantenimientoService.crear(planMantenimiento);

	}

	private void crearTarea(PlanMantenimiento planMantenimiento, String nombre, String descripcion) {
		Tarea tarea = new Tarea();
		tarea.setNombre(nombre);
		tarea.setDescripcion(descripcion);
		planMantenimiento.addTarea(tarea);
		tarea.setPlanMantenimiento(planMantenimiento);

	}

	private void crearNaves() {
		Map<String, String[]> naves = new HashMap<String, String[]>();
		naves.put("avion_01", new String[] { "Boing,747,Avianca", "Ala Izq,Ala Izq;Ala Der,Ala Der;Fusalaje,Fuselaje" });
		naves.put("helico_01", new String[] { "Agusta Wetsland,AW101 VVIP,2", "Rotor,Rotor;Patin,Patin;Tren,Tren" });
		naves.put("helico_02", new String[] { "Sikorky,S-92VVIP,1", "Rotor,Rotor;Patin,Patin;Tren,Tren" });
		for (Map.Entry<String, String[]> row : naves.entrySet()) {
			String[] datos = row.getValue()[0].split(",");
			if (row.getKey().contains("avion")) {
				crearAvion(datos[0], datos[1], datos[2], row.getValue()[1]);
			} else {
				crearHelicoptero(datos[0], datos[1], datos[2], row.getValue()[1]);
			}
		}
	}

	private void crearHelicoptero(String fabricante, String referencia, String rotores, String datos) {
		String[] dtCpnte = datos.split(";");
		Helicoptero helicoptero = new Helicoptero();
		helicoptero.setEstado("Activo");
		helicoptero.setFabricante(fabricante);
		helicoptero.setReferencia(referencia);
		helicoptero.setNumeroRotores(new Integer(rotores));
		for (String registro : dtCpnte) {
			String[] info = registro.split(",");
			crearComponente(helicoptero, info[0], info[1]);

		}
		dao.crear(helicoptero);
	}

	private void crearAvion(String fabricante, String referencia, String aerolinea, String datos) {
		String[] dtCpnte = datos.split(";");
		Avion nave = new Avion();
		nave.setEstado("Activo");
		nave.setFabricante(fabricante);
		nave.setReferencia(referencia);
		nave.setAerolinea(aerolinea);
		for (String registro : dtCpnte) {
			String[] info = registro.split(",");
			crearComponente(nave, info[0], info[1]);

		}

		dao.crear(nave);
	}

	private void crearComponente(Nave nave, String nombre, String descripcion) {
		Componente componente = new Componente();
		componente.setCostoRefraccon(new BigDecimal(2));
		componente.setNombre(nombre);
		componente.setDescripcion(descripcion);
		componente.setEstado("Activo");
		nave.addComponente(componente);
		componente.setNave(nave);
	}
}