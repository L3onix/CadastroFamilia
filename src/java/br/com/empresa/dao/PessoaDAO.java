/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.Pessoa;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class PessoaDAO implements BasicoDAO{

    @Override
    public void create(Object item) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(item);
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public Object read(Integer id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Pessoa pessoa = (Pessoa) sessao.merge(sessao.get(Pessoa.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return pessoa;
    }

    @Override
    public void update(Object item) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.merge(item);
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(Integer id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.delete(sessao.get(Pessoa.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public List<Object> listagem() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Object> pessoas = sessao.getNamedQuery("Pessoa.findAll").list();
        
        sessao.close();
        return pessoas;
    }
    
    public Pessoa readName(String nome){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Pessoa pessoa = (Pessoa) sessao.getNamedQuery("Pessoa.findByNome").setParameter("nome", nome).setMaxResults(1).uniqueResult();
        
        sessao.close();
        return pessoa;
    }
    
    public Pessoa readId(String id){
        int idPessoa = Integer.parseInt(id);
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Pessoa pessoa = (Pessoa) sessao.getNamedQuery("Pessoa.findById").setParameter("id", idPessoa).setMaxResults(1).uniqueResult();
        
        sessao.close();
        return pessoa;
    }
}
