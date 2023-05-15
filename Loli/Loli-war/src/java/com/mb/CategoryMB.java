/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Brand;
import com.entity.BrandCategory;
import com.entity.Category;
import com.sessionbean.BrandCategoryFacadeLocal;
import com.sessionbean.BrandFacadeLocal;
import com.sessionbean.CategoryFacadeLocal;
import com.sessionbean.RandomLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Admin
 */
@Named(value = "categoryMB")
@RequestScoped
public class CategoryMB {

    @EJB
    private BrandCategoryFacadeLocal brandCategoryFacade;

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private BrandFacadeLocal brandFacade;

    @EJB
    private RandomLocal random;

    private Category category;
    private List<Category> categoryList;
    private String categoryId;
    private Brand brand;
    List<BrandCategory> brandCategoryList;
 
    
    public CategoryMB() {
        category = new Category();
    }
    
    public String createCategory() {
        category.setStatusCategory(1);
        category.setIdCategory(random.randomcode(10));
        categoryFacade.create(category);
        category = new Category();
        categoryList = categoryFacade.findActive();

        return "CategoryCreateSuccess";
    }

    public String updateCategory() {
        categoryFacade.edit(category);
        category = new Category();
        categoryList = categoryFacade.findActive();
        return "CategoryEditSuccess";
    }

    public String deleteActiveCategory(Category c) {
        category = c;
        brandFacade.find(category.getIdCategory());
        category.setStatusCategory(0);
        categoryFacade.edit(category);
        category = new Category();
        categoryList = categoryFacade.findActive();
        return "/admin/category/manage?faces-redirect=true";
    }

    public String restoreActiveCategory(Category c) {
        category = c;
        brandFacade.find(category.getIdCategory());
        category.setStatusCategory(1);
        categoryFacade.edit(category);
        category = new Category();
        categoryList = categoryFacade.findActive();
        return "/admin/category/recycleBin?faces-redirect=true";
    }

    public String editCategory(Category c) {
        category = c;
        return "/admin/category/edit";
    }

    public List<Category> showCategory() {
        return categoryList = categoryFacade.findActive();
    }

    public List<Category> showRestoreCategory() {
        return categoryList = categoryFacade.findHidden();
    } 

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
