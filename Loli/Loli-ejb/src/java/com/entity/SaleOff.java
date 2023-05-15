/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "SaleOff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleOff.findAll", query = "SELECT s FROM SaleOff s")
    , @NamedQuery(name = "SaleOff.findByIdSale", query = "SELECT s FROM SaleOff s WHERE s.idSale = :idSale")
    , @NamedQuery(name = "SaleOff.findBySalename", query = "SELECT s FROM SaleOff s WHERE s.salename = :salename")
    , @NamedQuery(name = "SaleOff.findByDiscount", query = "SELECT s FROM SaleOff s WHERE s.discount = :discount")
    , @NamedQuery(name = "SaleOff.findByStartdate", query = "SELECT s FROM SaleOff s WHERE s.startdate = :startdate")
    , @NamedQuery(name = "SaleOff.findByEnddate", query = "SELECT s FROM SaleOff s WHERE s.enddate = :enddate")})
public class SaleOff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Sale")
    private String idSale;
    @Size(max = 50)
    @Column(name = "Sale_name")
    private String salename;
    @Column(name = "Discount")
    private Integer discount;
    @Column(name = "Startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "Enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @OneToMany(mappedBy = "idSale")
    private Collection<ProductSaleOff> productSaleOffCollection;

    public SaleOff() {
    }

    public SaleOff(String idSale) {
        this.idSale = idSale;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getSalename() {
        return salename;
    }

    public void setSalename(String salename) {
        this.salename = salename;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @XmlTransient
    public Collection<ProductSaleOff> getProductSaleOffCollection() {
        return productSaleOffCollection;
    }

    public void setProductSaleOffCollection(Collection<ProductSaleOff> productSaleOffCollection) {
        this.productSaleOffCollection = productSaleOffCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSale != null ? idSale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleOff)) {
            return false;
        }
        SaleOff other = (SaleOff) object;
        if ((this.idSale == null && other.idSale != null) || (this.idSale != null && !this.idSale.equals(other.idSale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SaleOff[ idSale=" + idSale + " ]";
    }
    
}
