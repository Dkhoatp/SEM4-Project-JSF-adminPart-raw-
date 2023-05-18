/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.CategoryTypex;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Admin
 */
@Stateless
public class CategoryTypexFacade extends AbstractFacade<CategoryTypex> implements CategoryTypexFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryTypexFacade() {
        super(CategoryTypex.class);
    }

    @Override
    public CategoryTypex showCategory(String idCategory, String idTypex) {
        TypedQuery<CategoryTypex> query = em.createQuery(
                "SELECT b FROM CategoryTypex b WHERE b.idCategory.idCategory = :idCategoryGet AND b.idTypex.idTypex = :idTypeGet", CategoryTypex.class);
        query.setParameter("idCategoryGet", idCategory);
        query.setParameter("idTypeGet", idTypex);
        return query.getSingleResult();
    }
    
}
