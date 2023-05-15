/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Qa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface QaFacadeLocal {

    void create(Qa qa);

    void edit(Qa qa);

    void remove(Qa qa);

    Qa find(Object id);

    List<Qa> findAll();

    List<Qa> findRange(int[] range);

    int count();
    
}
