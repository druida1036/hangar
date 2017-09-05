package co.edu.udistrital.controladores.servicios;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.modelo.dao.RegistroMantenimientoDAO;
import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.DetalleMantenimiento;
import co.edu.udistrital.modelo.entidades.Nave;
import co.edu.udistrital.modelo.entidades.PlanMantenimiento;
import co.edu.udistrital.modelo.entidades.RegistroMantenimiento;
import co.edu.udistrital.modelo.entidades.Tarea;

@Service
public class RegistroMantenimientoServicioImpl implements RegistroMantenimientoService {

	@Autowired
	private RegistroMantenimientoDAO dao;

	@Override
	public RegistroMantenimiento crear(Nave nave, PlanMantenimiento plan, List<Componente> componentes,
			List<Tarea> tareas) {
		RegistroMantenimiento registroMantenimiento = new RegistroMantenimiento();
		registroMantenimiento.setPlanMantenimiento(plan);
		registroMantenimiento.setNave(nave);
		registroMantenimiento.setFecha(new Date());
		BigDecimal total = new BigDecimal("0");
		for (Componente componente : componentes) {
			for (Tarea tarea : tareas) {
				DetalleMantenimiento detalleMantenimiento = new DetalleMantenimiento();
				detalleMantenimiento.setTipo_mnto("Preventivo");
				detalleMantenimiento.setCosto(new BigDecimal(Math.random()*100));
				registroMantenimiento.getDetalleMantenimientos().add(detalleMantenimiento);
				detalleMantenimiento.setMantenmiento(registroMantenimiento);
				detalleMantenimiento.setComponente(componente);
				detalleMantenimiento.setTarea(tarea);
				
				total = total.add(detalleMantenimiento.getCosto());
			}
		}
		registroMantenimiento.setTotal(total);
		return dao.crear(registroMantenimiento);
	}

	@Override
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento) {
		return dao.actualizar(registroMantenimiento);
	}

	@Override
	public RegistroMantenimiento consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<RegistroMantenimiento> consultar() {
		return dao.consultar();
	}

}
