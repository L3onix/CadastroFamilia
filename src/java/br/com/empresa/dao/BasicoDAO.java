/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import java.util.List;

/**
 *
 * @author leonix
 */
public interface BasicoDAO {
    public void create(Object item);
    public Object read(Integer id);
    public void update(Object item);
    public void delete(Integer id);
    public List<Object> listagem();
}
