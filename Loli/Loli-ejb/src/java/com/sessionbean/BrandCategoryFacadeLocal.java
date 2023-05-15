/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.BrandCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface BrandCategoryFacadeLocal {


    BrandCategory showBrand(String idBrand, String idCategory);

    void create(BrandCategory brandCategory);

    void edit(BrandCategory brandCategory);

    void remove(BrandCategory brandCategory);

    BrandCategory find(Object id);

    List<BrandCategory> findAll();

    List<BrandCategory> findRange(int[] range);

    int count();

}
