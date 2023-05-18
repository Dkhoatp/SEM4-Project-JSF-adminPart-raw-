/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.AddressList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface AddressListFacadeLocal {

    void create(AddressList addressList);

    void edit(AddressList addressList);

    void remove(AddressList addressList);

    AddressList find(Object id);

    List<AddressList> findAll();

    List<AddressList> findRange(int[] range);

    int count();
    
}
