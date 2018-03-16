/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.PessoaQualidade;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class PessoaQualidadeDAO implements BasicoDAO{

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
        
        PessoaQualidade pessoaQualidade = (PessoaQualidade) sessao.merge(sessao.get(PessoaQualidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return pessoaQualidade;
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
        
        sessao.delete(sessao.get(PessoaQualidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public List<Object> listagem() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Object> pessoaQualidade = sessao.getNamedQuery("PessoaQualidade.findAll").list();
        
        sessao.close();
        return pessoaQualidade;
    }
    
}
