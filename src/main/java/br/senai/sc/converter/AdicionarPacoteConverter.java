package br.senai.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.dao.DestinoDao_OLD;
import br.senai.sc.entity.Destino;
import br.senai.sc.entity.Pacote;

@FacesConverter(forClass=Pacote.class)
public class AdicionarPacoteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		DestinoDao_OLD dao = new DestinoDao_OLD();
		Long id = Long.valueOf(value);
		return dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
		Destino destino = (Destino) value;
		return destino.getId().toString();
	}

}
