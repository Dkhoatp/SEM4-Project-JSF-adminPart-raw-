/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.BrandCategory;
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
public class BrandCategoryFacade extends AbstractFacade<BrandCategory> implements BrandCategoryFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandCategoryFacade() {
        super(BrandCategory.class);
    }

    @Override
    public BrandCategory showBrand(String idBrand, String idCategory) {
        TypedQuery<BrandCategory> query = em.createQuery(
                "SELECT b FROM BrandCategory b WHERE b.idBrand.idBrand = :idDBrandGet AND b.idCategory.idCategory = :idCategoryGet", BrandCategory.class);
        query.setParameter("idDBrandGet", idBrand);
        query.setParameter("idCategoryGet", idCategory);
        return query.getSingleResult();
    }

}
