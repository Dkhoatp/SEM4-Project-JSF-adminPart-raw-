/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Historylogin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface HistoryloginFacadeLocal {

    void create(Historylogin historylogin);

    void edit(Historylogin historylogin);

    void remove(Historylogin historylogin);

    Historylogin find(Object id);

    List<Historylogin> findAll();

    List<Historylogin> findRange(int[] range);

    int count();
    
}
