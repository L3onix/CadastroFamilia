/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.PessoaDAO;
import br.com.empresa.entidade.Pessoa;
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
public class PessoaMB {
    private Pessoa pessoa;
    private List<Object> lista;
    private PessoaDAO dao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializaTela(){
        dao = new PessoaDAO();
        lista = dao.listagem();
        
        limpar();
    }
    
    public void limpar(){
        pessoa = new Pessoa();
    }
    
    public void salvar(){
        dao = new PessoaDAO();
        if(pessoa.getId() == null){
            dao.create(pessoa);
        }else{
            dao.update(pessoa);
        }
        
        inicializaTela();
    }
    
    public void deletar(Pessoa item){
        dao = new PessoaDAO();
        dao.create(item.getId());
        
        inicializaTela();
    }
    
    public void carregarPessoa(Pessoa item){
        pessoa = item;
    }
}
