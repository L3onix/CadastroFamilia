/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.converter;

import br.com.empresa.dao.EnderecoDAO;
import br.com.empresa.entidade.Endereco;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonix
 */
@FacesConverter("enderecoConverter")
public class EnderecoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        EnderecoDAO dao = new EnderecoDAO();
        return dao.readId(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object endereco) {
        String id = Integer.toString(((Endereco) endereco).getId());
        return id;
    }
    
}
