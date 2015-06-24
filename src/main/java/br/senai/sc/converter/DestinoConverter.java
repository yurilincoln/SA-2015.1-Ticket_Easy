package br.senai.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.dao.DestinoDao;
import br.senai.sc.entity.Destino;

@FacesConverter("destinoConverter")
public class DestinoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		DestinoDao dao = new DestinoDao();
		Long id = Long.valueOf(value);
		return dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
		Destino destino = (Destino) value;
		return destino.getId().toString();
	}

}
