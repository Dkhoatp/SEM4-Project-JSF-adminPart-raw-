/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.CategoryTypex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface CategoryTypexFacadeLocal {

    CategoryTypex showCategory(String idCategory, String idTypex);
    
    void create(CategoryTypex categoryTypex);

    void edit(CategoryTypex categoryTypex);

    void remove(CategoryTypex categoryTypex);

    CategoryTypex find(Object id);

    List<CategoryTypex> findAll();

    List<CategoryTypex> findRange(int[] range);

    int count();
    
}
