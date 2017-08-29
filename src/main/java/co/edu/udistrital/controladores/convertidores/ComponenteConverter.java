package co.edu.udistrital.controladores.convertidores;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

import co.edu.udistrital.modelo.Componente;

@Component
@FacesConverter("componenteConverter")
public class ComponenteConverter implements Converter {

	private List<Componente> listado;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return consultar(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	private Componente consultar(int id) {
		for (Componente componente : listado) {
			if (componente.getId() == id) {
				return componente;
			}
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null && object instanceof Componente) {
			return String.valueOf(((Componente) object).getId());
		} else {
			return null;
		}
	}

	/**
	 * @return the listado
	 */
	public List<Componente> getListado() {
		return listado;
	}

	/**
	 * @param listado the listado to set
	 */
	public void setListado(List<Componente> listado) {
		this.listado = listado;
	}
}