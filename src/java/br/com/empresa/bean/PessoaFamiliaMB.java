/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.PessoaFamiliaDAO;
import br.com.empresa.entidade.PessoaFamilia;
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
public class PessoaFamiliaMB {
    private PessoaFamilia pessoaFamilia;
    private List<Object> lista;
    private PessoaFamiliaDAO dao;

    public PessoaFamilia getPessoaFamilia() {
        return pessoaFamilia;
    }

    public void setPessoaFamilia(PessoaFamilia pessoaFamilia) {
        this.pessoaFamilia = pessoaFamilia;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializaTela(){
        dao = new PessoaFamiliaDAO();
        lista = dao.listagem();
        
        limpar();
    }
    
    public void limpar(){
        pessoaFamilia = new PessoaFamilia();
    }
    
    public void salvar(){
        dao = new PessoaFamiliaDAO();
        if(pessoaFamilia.getId() == null){
            dao.create(pessoaFamilia);
        }else{
            dao.update(pessoaFamilia);
        }
        
        inicializaTela();
    }
    
    public void deletar(PessoaFamilia item){
        dao = new PessoaFamiliaDAO();
        dao.delete(item.getId());
        
        inicializaTela();
    }
    
    public void carregarPessoaFamilia(PessoaFamilia item){
        pessoaFamilia = item;
    }
}
