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
@Table(name = "Product_SaleOff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSaleOff.findAll", query = "SELECT p FROM ProductSaleOff p")
    , @NamedQuery(name = "ProductSaleOff.findByIdSaleOff", query = "SELECT p FROM ProductSaleOff p WHERE p.idSaleOff = :idSaleOff")})
public class ProductSaleOff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_SaleOff")
    private String idSaleOff;
    @JoinColumn(name = "Id_Product", referencedColumnName = "Id_Product")
    @ManyToOne
    private Product idProduct;
    @JoinColumn(name = "Id_Sale", referencedColumnName = "Id_Sale")
    @ManyToOne
    private SaleOff idSale;

    public ProductSaleOff() {
    }

    public ProductSaleOff(String idSaleOff) {
        this.idSaleOff = idSaleOff;
    }

    public String getIdSaleOff() {
        return idSaleOff;
    }

    public void setIdSaleOff(String idSaleOff) {
        this.idSaleOff = idSaleOff;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public SaleOff getIdSale() {
        return idSale;
    }

    public void setIdSale(SaleOff idSale) {
        this.idSale = idSale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaleOff != null ? idSaleOff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSaleOff)) {
            return false;
        }
        ProductSaleOff other = (ProductSaleOff) object;
        if ((this.idSaleOff == null && other.idSaleOff != null) || (this.idSaleOff != null && !this.idSaleOff.equals(other.idSaleOff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ProductSaleOff[ idSaleOff=" + idSaleOff + " ]";
    }
    
}
