/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.ProductSaleOff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class ProductSaleOffFacade extends AbstractFacade<ProductSaleOff> implements ProductSaleOffFacadeLocal {

    @PersistenceContext(unitName = "Loli-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductSaleOffFacade() {
        super(ProductSaleOff.class);
    }
    
}
