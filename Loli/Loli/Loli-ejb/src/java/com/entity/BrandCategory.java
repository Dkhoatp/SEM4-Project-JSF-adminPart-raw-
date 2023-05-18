/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "BrandCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandCategory.findAll", query = "SELECT b FROM BrandCategory b")
    , @NamedQuery(name = "BrandCategory.findByIdCategoryBrand", query = "SELECT b FROM BrandCategory b WHERE b.idCategoryBrand = :idCategoryBrand")})
public class BrandCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_CategoryBrand")
    private String idCategoryBrand;
    @JoinColumn(name = "Id_Brand", referencedColumnName = "Id_Brand")
    @ManyToOne
    private Brand idBrand;
    @JoinColumn(name = "Id_Category", referencedColumnName = "Id_Category")
    @ManyToOne
    private Category idCategory;

    public BrandCategory() {
    }

    public BrandCategory(String idCategoryBrand) {
        this.idCategoryBrand = idCategoryBrand;
    }

    public String getIdCategoryBrand() {
        return idCategoryBrand;
    }

    public void setIdCategoryBrand(String idCategoryBrand) {
        this.idCategoryBrand = idCategoryBrand;
    }

    public Brand getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Brand idBrand) {
        this.idBrand = idBrand;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoryBrand != null ? idCategoryBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandCategory)) {
            return false;
        }
        BrandCategory other = (BrandCategory) object;
        if ((this.idCategoryBrand == null && other.idCategoryBrand != null) || (this.idCategoryBrand != null && !this.idCategoryBrand.equals(other.idCategoryBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.BrandCategory[ idCategoryBrand=" + idCategoryBrand + " ]";
    }
    
}
