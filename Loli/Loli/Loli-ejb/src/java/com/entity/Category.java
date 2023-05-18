/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByIdCategory", query = "SELECT c FROM Category c WHERE c.idCategory = :idCategory")
    , @NamedQuery(name = "Category.findByNameCategory", query = "SELECT c FROM Category c WHERE c.nameCategory = :nameCategory")
    , @NamedQuery(name = "Category.findByStatusCategory", query = "SELECT c FROM Category c WHERE c.statusCategory = :statusCategory")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Category")
    private String idCategory;
    @Size(max = 100)
    @Column(name = "Name_Category")
    private String nameCategory;
    @Column(name = "Status_Category")
    private Integer statusCategory;
    @OneToMany(mappedBy = "idCategory")
    private Collection<BrandCategory> brandCategoryCollection;
    @OneToMany(mappedBy = "idCategory")
    private Collection<CategoryTypex> categoryTypexCollection;

    public Category() {
    }

    public Category(String idCategory) {
        this.idCategory = idCategory;
    }

    public Category(String test156, String select_Category, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(Integer statusCategory) {
        this.statusCategory = statusCategory;
    }

    @XmlTransient
    public Collection<BrandCategory> getBrandCategoryCollection() {
        return brandCategoryCollection;
    }

    public void setBrandCategoryCollection(Collection<BrandCategory> brandCategoryCollection) {
        this.brandCategoryCollection = brandCategoryCollection;
    }

    @XmlTransient
    public Collection<CategoryTypex> getCategoryTypexCollection() {
        return categoryTypexCollection;
    }

    public void setCategoryTypexCollection(Collection<CategoryTypex> categoryTypexCollection) {
        this.categoryTypexCollection = categoryTypexCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategory != null ? idCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Category[ idCategory=" + idCategory + " ]";
    }
    
}
