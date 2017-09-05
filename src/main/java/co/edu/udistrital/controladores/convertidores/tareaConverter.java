package co.edu.udistrital.controladores.convertidores;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udistrital.controladores.servicios.TareaService;
import co.edu.udistrital.modelo.entidades.Tarea;
 
@Component
@FacesConverter("tareaConverter")
public class tareaConverter implements Converter {
	
	@Autowired
	private TareaService service;
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("tarea object "+value);
                return service.consultar(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
        	System.out.println("converter object "+value);
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null && object instanceof Tarea) {
            return String.valueOf(((Tarea) object).getId());
        }
        else {
        	System.out.println("converter string "+object);
            return null;
        }
    }   
}     