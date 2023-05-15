/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.ProductSaleOff;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface ProductSaleOffFacadeLocal {

    void create(ProductSaleOff productSaleOff);

    void edit(ProductSaleOff productSaleOff);

    void remove(ProductSaleOff productSaleOff);

    ProductSaleOff find(Object id);

    List<ProductSaleOff> findAll();

    List<ProductSaleOff> findRange(int[] range);

    int count();
    
}
