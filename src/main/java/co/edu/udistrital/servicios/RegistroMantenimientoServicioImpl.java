package co.edu.udistrital.servicios;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.dao.RegistroMantenimientoDAO;
import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.DetalleMantenimiento;
import co.edu.udistrital.modelo.Nave;
import co.edu.udistrital.modelo.PlanMantenimiento;
import co.edu.udistrital.modelo.RegistroMantenimiento;
import co.edu.udistrital.modelo.Tarea;

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
				registroMantenimiento.getDetalleMantenimientos().add(detalleMantenimiento);
				detalleMantenimiento.setMantenmiento(registroMantenimiento);
				detalleMantenimiento.setComponente(componente);
				detalleMantenimiento.setTarea(tarea);
				detalleMantenimiento.setCosto(new BigDecimal(Math.random()*100));
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
