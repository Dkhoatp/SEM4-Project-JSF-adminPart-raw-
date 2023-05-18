/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public List<Product> findActive() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT b FROM Product b WHERE b.quatity != :quatity order by b.productName", Product.class);
        query.setParameter("quatity", 0);
        return query.getResultList();
    }

    @Override
    public List<Product> findHidden() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT b FROM Product b WHERE b.quatity = :quatity order by b.productName", Product.class);
        query.setParameter("quatity", 0);
        return query.getResultList();
    }
    
}
