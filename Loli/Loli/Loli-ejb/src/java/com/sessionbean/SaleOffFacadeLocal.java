/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.SaleOff;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface SaleOffFacadeLocal {

    void create(SaleOff saleOff);

    void edit(SaleOff saleOff);

    void remove(SaleOff saleOff);

    SaleOff find(Object id);

    List<SaleOff> findAll();

    List<SaleOff> findRange(int[] range);

    int count();
    
}
