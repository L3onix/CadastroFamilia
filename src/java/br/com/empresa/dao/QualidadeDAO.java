/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.Qualidade;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class QualidadeDAO implements BasicoDAO{

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
        
        Qualidade qualidade = (Qualidade) sessao.merge(sessao.get(Qualidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return qualidade;
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
        
        sessao.delete(sessao.get(Qualidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public List<Object> listagem() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Object> qualidades = sessao.getNamedQuery("Qualidade.findAll").list();
        
        sessao.close();
        return qualidades;
    }
    
    public Qualidade readId(String id){
        int idQualidade = Integer.parseInt(id);
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Qualidade qualidade = (Qualidade) sessao.getNamedQuery("Qualidade.findById").setParameter("id", idQualidade).setMaxResults(1).uniqueResult();
        
        sessao.close();
        return qualidade;
    }
    
}
