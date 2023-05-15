/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Typex;
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
public class TypexFacade extends AbstractFacade<Typex> implements TypexFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypexFacade() {
        super(Typex.class);
    }

    @Override
    public List<Typex> findActive() {
       TypedQuery<Typex> query = em.createQuery(
                "SELECT c FROM Typex c WHERE c.statusTypex = :status order by c.nameTypex", Typex.class);
        query.setParameter("status", 1);
        return query.getResultList();
    }

    @Override
    public List<Typex> findHidden() {
        TypedQuery<Typex> query = em.createQuery(
                "SELECT c FROM Typex c WHERE c.statusTypex = :status order by c.nameTypex", Typex.class);
        query.setParameter("status", 0);
        return query.getResultList();
    }
    
}
