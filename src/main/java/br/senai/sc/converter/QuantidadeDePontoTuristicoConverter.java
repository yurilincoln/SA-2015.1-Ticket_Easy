package br.senai.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.dao.QuantidadeDePontoTuristicoDao;
import br.senai.sc.entity.QuantidadeDePontoTuristico;

@FacesConverter(forClass=QuantidadeDePontoTuristico.class)
public class QuantidadeDePontoTuristicoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		QuantidadeDePontoTuristicoDao dao = new QuantidadeDePontoTuristicoDao();
		Long id = Long.valueOf(value);
		return dao.buscaPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
		QuantidadeDePontoTuristico tipoCanal = (QuantidadeDePontoTuristico) value;
		return tipoCanal.getId().toString();
	}

	
}
