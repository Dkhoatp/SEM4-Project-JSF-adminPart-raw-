/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Typex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface TypexFacadeLocal {

    void create(Typex typex);

    void edit(Typex typex);

    void remove(Typex typex);

    Typex find(Object id);

    List<Typex> findAll();

    List<Typex> findRange(int[] range);

    int count();

    public List<Typex> findActive();

    public List<Typex> findHidden();    
}
