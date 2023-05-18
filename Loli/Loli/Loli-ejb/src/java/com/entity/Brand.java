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
@Table(name = "Brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b")
    , @NamedQuery(name = "Brand.findByIdBrand", query = "SELECT b FROM Brand b WHERE b.idBrand = :idBrand")
    , @NamedQuery(name = "Brand.findByNameBrand", query = "SELECT b FROM Brand b WHERE b.nameBrand = :nameBrand")
    , @NamedQuery(name = "Brand.findByImages", query = "SELECT b FROM Brand b WHERE b.images = :images")
    , @NamedQuery(name = "Brand.findByStatusBrand", query = "SELECT b FROM Brand b WHERE b.statusBrand = :statusBrand")})
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Brand")
    private String idBrand;
    @Size(max = 100)
    @Column(name = "Name_Brand")
    private String nameBrand;
    @Size(max = 255)
    @Column(name = "Images")
    private String images;
    @Column(name = "Status_Brand")
    private Integer statusBrand;
    @OneToMany(mappedBy = "idBrand")
    private Collection<BrandCategory> brandCategoryCollection;

    public Brand() {
    }

    public Brand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getStatusBrand() {
        return statusBrand;
    }

    public void setStatusBrand(Integer statusBrand) {
        this.statusBrand = statusBrand;
    }

    @XmlTransient
    public Collection<BrandCategory> getBrandCategoryCollection() {
        return brandCategoryCollection;
    }

    public void setBrandCategoryCollection(Collection<BrandCategory> brandCategoryCollection) {
        this.brandCategoryCollection = brandCategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBrand != null ? idBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.idBrand == null && other.idBrand != null) || (this.idBrand != null && !this.idBrand.equals(other.idBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Brand[ idBrand=" + idBrand + " ]";
    }
    
}
