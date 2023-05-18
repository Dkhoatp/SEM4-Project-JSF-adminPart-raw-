/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Ordersdetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface OrdersdetailFacadeLocal {

    void create(Ordersdetail ordersdetail);

    void edit(Ordersdetail ordersdetail);

    void remove(Ordersdetail ordersdetail);

    Ordersdetail find(Object id);

    List<Ordersdetail> findAll();

    List<Ordersdetail> findRange(int[] range);

    int count();
    
}
