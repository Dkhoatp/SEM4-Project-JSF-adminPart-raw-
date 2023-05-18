/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Category;
import java.util.List;
import java.util.Locale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Admin
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public List<Category> findActive() {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.statusCategory = :status order by c.nameCategory", Category.class);
        query.setParameter("status", 1);
        return query.getResultList();
    }

    @Override
    public List<Category> findHidden() {
         TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.statusCategory = :status order by c.nameCategory", Category.class);
        query.setParameter("status", 0);
        return query.getResultList();
    }
    
}
