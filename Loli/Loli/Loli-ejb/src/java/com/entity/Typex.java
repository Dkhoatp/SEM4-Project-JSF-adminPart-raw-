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
@Table(name = "Typex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typex.findAll", query = "SELECT t FROM Typex t")
    , @NamedQuery(name = "Typex.findByIdTypex", query = "SELECT t FROM Typex t WHERE t.idTypex = :idTypex")
    , @NamedQuery(name = "Typex.findByNameTypex", query = "SELECT t FROM Typex t WHERE t.nameTypex = :nameTypex")
    , @NamedQuery(name = "Typex.findByStatusTypex", query = "SELECT t FROM Typex t WHERE t.statusTypex = :statusTypex")})
public class Typex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Typex")
    private String idTypex;
    @Size(max = 100)
    @Column(name = "Name_Typex")
    private String nameTypex;
    @Column(name = "Status_Typex")
    private Integer statusTypex;
    @OneToMany(mappedBy = "idTypex")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "idTypex")
    private Collection<CategoryTypex> categoryTypexCollection;

    public Typex() {
    }

    public Typex(String idTypex) {
        this.idTypex = idTypex;
    }

    public String getIdTypex() {
        return idTypex;
    }

    public void setIdTypex(String idTypex) {
        this.idTypex = idTypex;
    }

    public String getNameTypex() {
        return nameTypex;
    }

    public void setNameTypex(String nameTypex) {
        this.nameTypex = nameTypex;
    }

    public Integer getStatusTypex() {
        return statusTypex;
    }

    public void setStatusTypex(Integer statusTypex) {
        this.statusTypex = statusTypex;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
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
        hash += (idTypex != null ? idTypex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typex)) {
            return false;
        }
        Typex other = (Typex) object;
        if ((this.idTypex == null && other.idTypex != null) || (this.idTypex != null && !this.idTypex.equals(other.idTypex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Typex[ idTypex=" + idTypex + " ]";
    }
    
}
