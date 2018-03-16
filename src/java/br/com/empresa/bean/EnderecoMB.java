/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.EnderecoDAO;
import br.com.empresa.entidade.Endereco;
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
public class EnderecoMB {
    private Endereco endereco;
    private List<Object> lista;
    private EnderecoDAO dao;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializaTela(){
        dao = new EnderecoDAO();
        lista = dao.listagem();
        
        limpar();
    }
    
    public void limpar(){
        endereco = new Endereco();
    }
    
    public void salvar(){
        dao = new EnderecoDAO();
        if(endereco.getId() == null){
            dao.create(endereco);
        }else{
            dao.update(endereco);
        }
        
        inicializaTela();
    }
    
    public void deletar(Endereco item){
        dao = new EnderecoDAO();
        dao.delete(item.getId());
        
        inicializaTela();
    }
    
    public void carregarEndereco(Endereco item){
        endereco = item;
    }
}
