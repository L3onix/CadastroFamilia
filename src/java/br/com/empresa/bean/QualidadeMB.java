/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.QualidadeDAO;
import br.com.empresa.entidade.Qualidade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author leonix
 */
@ManagedBean
@ViewScoped
public class QualidadeMB {
    private Qualidade qualidade;
    private List<Object> lista;
    private QualidadeDAO dao;

    public Qualidade getQualidade() {
        return qualidade;
    }

    public void setQualidade(Qualidade qualidade) {
        this.qualidade = qualidade;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializaTela(){
        dao = new QualidadeDAO();
        lista = dao.listagem();
        
        limpar();
    }
    
    public void limpar(){
        qualidade = new Qualidade();
    }
    
    public void salvar(){
        dao = new QualidadeDAO();
        if(qualidade.getId() == null){
            dao.create(qualidade);
        }else{
            dao.update(qualidade);
        }
        
        inicializaTela();
    }
    
    public void deletar(Qualidade item){
        dao = new QualidadeDAO();
        dao.delete(item.getId());
        
        inicializaTela();
    }
    
    public void carregar(Qualidade item){
        qualidade = item;
    }
}
