/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Brand;
import com.entity.BrandCategory;
import com.entity.Category;
import com.entity.CategoryTypex;
import com.entity.Typex;
import com.sessionbean.BrandCategoryFacadeLocal;
import com.sessionbean.BrandFacadeLocal;
import com.sessionbean.CategoryFacadeLocal;
import com.sessionbean.CategoryTypexFacadeLocal;
import com.sessionbean.RandomLocal;
import com.sessionbean.TypexFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Admin
 */
@Named(value = "bridgeMB")
@SessionScoped
public class BridgeMB implements Serializable {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private TypexFacadeLocal typexFacade;

    @EJB
    private CategoryTypexFacadeLocal categoryTypexFacade;

    @EJB
    private RandomLocal random;

    @EJB
    private BrandCategoryFacadeLocal brandCategoryFacade;

    @EJB
    private BrandFacadeLocal brandFacade;

    
    private Category category;

    private Typex typex;
    
    public BridgeMB() {
    }

    public String editBrandCategory(Category c) {
        category = c;
        return "CategoryAddBrand";
    }
    public String editCategoryTypex(Typex t) {
        typex = t;
        return "TypexAddCategory";
    }

    public String addBrandCategory(Brand brand) {
        BrandCategory bc = new BrandCategory();
        bc.setIdCategoryBrand(random.randomcode(10));
        bc.setIdCategory(category);
        bc.setIdBrand(brand);
        brandCategoryFacade.create(bc);
        return "addBrandCategory";
    }
    public String addCategoryTypex(Category category) {
        CategoryTypex ct = new CategoryTypex();
        ct.setIdCategoryTypex(random.randomcode(10));
        ct.setIdTypex(typex);
        ct.setIdCategory(category);
        categoryTypexFacade.create(ct);
        return "addCategoryTypex";
    }

    public String removeBrandCategory(Brand brand) {
       brandCategoryFacade.remove(brandCategoryFacade.showBrand(brand.getIdBrand(), category.getIdCategory()));
        return "removeBrandCategory";
    }
    public String removeCategoryTypex(Category category) {
       categoryTypexFacade.remove(categoryTypexFacade.showCategory(category.getIdCategory(), typex.getIdTypex()));
        return "removeCategoryTypex";
    }

    public List<Brand> checkBrandCategoty() {
        List<Brand> listBrandCategoty = brandFacade.findActive();
        for (BrandCategory brandCategory : brandCategoryFacade.findAll()) {
            if (brandCategory.getIdCategory().getIdCategory().equals(category.getIdCategory())) {
                int index = listBrandCategoty.indexOf(brandCategory.getIdBrand());
                listBrandCategoty.remove(index);
            }
        }
        return listBrandCategoty;
    }
    public List<Category> checkCategoryTypex() {
        List<Category> listCategoryTypex = categoryFacade.findActive();
        for (CategoryTypex categoryTypex : categoryTypexFacade.findAll()) {
            if (categoryTypex.getIdTypex().getIdTypex().equals(typex.getIdTypex())) {
                int index = listCategoryTypex.indexOf(categoryTypex.getIdCategory());
                listCategoryTypex.remove(index);
            }
        }
        return listCategoryTypex;
    }

    public List<Brand> showBrandCategoty() {
        List<Brand> listBrandCategoty = new ArrayList<>();
        for (BrandCategory brandCategory : brandCategoryFacade.findAll()) {
            if (brandCategory.getIdCategory().getIdCategory().equals(category.getIdCategory())) {
                listBrandCategoty.add(brandCategory.getIdBrand());
            }
        }
        return listBrandCategoty;
    }
    public List<Category> showCategoryTypex() {
        List<Category> ListCategoryTypex = new ArrayList<>();
        for (CategoryTypex categoryTypex : categoryTypexFacade.findAll()) {
            if (categoryTypex.getIdTypex().getIdTypex().equals(typex.getIdTypex())) {
                ListCategoryTypex.add(categoryTypex.getIdCategory());
            }
        }
        return ListCategoryTypex;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Typex getTypex() {
        return typex;
    }

    public void setTypex(Typex typex) {
        this.typex = typex;
    }
 

}
