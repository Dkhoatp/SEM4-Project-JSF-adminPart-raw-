/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Product;
import com.sessionbean.ProductFacade;
import com.sessionbean.ProductFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Admin
 */
@Named(value = "productMB")
@RequestScoped
public class productMB {

    @EJB
    private ProductFacadeLocal productFacade;

    
    String idProduct;
    String idType;
    List<Product> productList;
    Product product;

    public productMB() {
    }

    public List<Product> showProduct() {
        return productList = productFacade.findActive();
    }
}
