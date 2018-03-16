/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.converter;

import br.com.empresa.dao.PessoaDAO;
import br.com.empresa.entidade.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonix
 */
@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        PessoaDAO dao = new PessoaDAO();
        return dao.readId(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object pessoa) {
        String id = Integer.toString(((Pessoa) pessoa).getId());
        return id;
    }

}
