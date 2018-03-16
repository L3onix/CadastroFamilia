/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.Endereco;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class EnderecoDAO implements BasicoDAO{

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
        
        Endereco endereco = (Endereco) sessao.merge(sessao.get(Endereco.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return endereco;
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
        
        sessao.delete(sessao.get(Endereco.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public List<Object> listagem() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Object> enderecos = sessao.getNamedQuery("Endereco.findAll").list();
        
        sessao.close();
        return enderecos;
    }
    
    public Endereco readId(String id){
        int idEndereco = Integer.parseInt(id);
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Endereco endereco = (Endereco) sessao.getNamedQuery("Endereco.findById").setParameter("id", idEndereco).setMaxResults(1).uniqueResult();
        
        sessao.close();
        return endereco;
    }
}
