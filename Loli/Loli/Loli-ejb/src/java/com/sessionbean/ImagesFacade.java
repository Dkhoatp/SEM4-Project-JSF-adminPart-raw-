/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Images;
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
public class ImagesFacade extends AbstractFacade<Images> implements ImagesFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagesFacade() {
        super(Images.class);
    }

    @Override
    public List<Images> showImageAll(String idProdcut) {
        TypedQuery<Images> query = em.createQuery(
                "SELECT i FROM Images i WHERE i.idProduct.idProduct = :idProdcut ", Images.class);
        query.setParameter("idProdcut", idProdcut);
        return query.getResultList();
    }

}
