/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.PessoaQualidadeDAO;
import br.com.empresa.entidade.PessoaQualidade;
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
public class PessoaQualidadeMB {
    private PessoaQualidade pessoaQualidade;
    private List<Object> lista;
    private PessoaQualidadeDAO dao;

    public PessoaQualidade getPessoaQualidade() {
        return pessoaQualidade;
    }

    public void setPessoaQualidade(PessoaQualidade pessoaQualidade) {
        this.pessoaQualidade = pessoaQualidade;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializaTela(){
        dao = new PessoaQualidadeDAO();
        lista = dao.listagem();
        
        limpar();
    }
    
    public void limpar(){
        pessoaQualidade = new PessoaQualidade();
    }
    
    public void salvar(){
        dao = new PessoaQualidadeDAO();
        if(pessoaQualidade.getId() == null){
            dao.create(pessoaQualidade);
        }else{
            dao.update(pessoaQualidade);
        }
        
        inicializaTela();
    }
    
    public void deletar(PessoaQualidade item){
        dao = new PessoaQualidadeDAO();
        dao.delete(item.getId());
        
        inicializaTela();
    }
    
    public void carregar(PessoaQualidade item){
        pessoaQualidade = item;
    }
}
