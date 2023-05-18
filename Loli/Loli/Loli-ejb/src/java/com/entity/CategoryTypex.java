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
@Table(name = "CategoryTypex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryTypex.findAll", query = "SELECT c FROM CategoryTypex c")
    , @NamedQuery(name = "CategoryTypex.findByIdCategoryTypex", query = "SELECT c FROM CategoryTypex c WHERE c.idCategoryTypex = :idCategoryTypex")})
public class CategoryTypex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_CategoryTypex")
    private String idCategoryTypex;
    @JoinColumn(name = "Id_Category", referencedColumnName = "Id_Category")
    @ManyToOne
    private Category idCategory;
    @JoinColumn(name = "Id_Typex", referencedColumnName = "Id_Typex")
    @ManyToOne
    private Typex idTypex;

    public CategoryTypex() {
    }

    public CategoryTypex(String idCategoryTypex) {
        this.idCategoryTypex = idCategoryTypex;
    }

    public String getIdCategoryTypex() {
        return idCategoryTypex;
    }

    public void setIdCategoryTypex(String idCategoryTypex) {
        this.idCategoryTypex = idCategoryTypex;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Typex getIdTypex() {
        return idTypex;
    }

    public void setIdTypex(Typex idTypex) {
        this.idTypex = idTypex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoryTypex != null ? idCategoryTypex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryTypex)) {
            return false;
        }
        CategoryTypex other = (CategoryTypex) object;
        if ((this.idCategoryTypex == null && other.idCategoryTypex != null) || (this.idCategoryTypex != null && !this.idCategoryTypex.equals(other.idCategoryTypex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.CategoryTypex[ idCategoryTypex=" + idCategoryTypex + " ]";
    }
    
}
