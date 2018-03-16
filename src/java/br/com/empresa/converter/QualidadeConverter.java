/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.converter;

import br.com.empresa.dao.QualidadeDAO;
import br.com.empresa.entidade.Qualidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonix
 */
@FacesConverter("qualidadeConverter")
public class QualidadeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        QualidadeDAO dao = new QualidadeDAO();
        return dao.readId(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object qualidade) {
        String id = Integer.toString(((Qualidade) qualidade).getId());
        return id;
    }
    
}
