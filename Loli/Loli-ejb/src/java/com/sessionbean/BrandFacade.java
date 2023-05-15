/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Brand;
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
public class BrandFacade extends AbstractFacade<Brand> implements BrandFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandFacade() {
        super(Brand.class);
    }

    @Override
    public List<Brand> findActive() {
        TypedQuery<Brand> query = em.createQuery(
                "SELECT b FROM Brand b WHERE b.statusBrand = :status order by b.nameBrand", Brand.class);
        query.setParameter("status", 1);
        return query.getResultList();
    }

    @Override
    public List<Brand> findHidden() {
        TypedQuery<Brand> query = em.createQuery(
                "SELECT b FROM Brand b WHERE b.statusBrand = :status order by b.nameBrand", Brand.class);
        query.setParameter("status", 0);
        return query.getResultList();
    }

  
}
