/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Ordersdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordersdetail.findAll", query = "SELECT o FROM Ordersdetail o")
    , @NamedQuery(name = "Ordersdetail.findByIdOrderdetail", query = "SELECT o FROM Ordersdetail o WHERE o.idOrderdetail = :idOrderdetail")
    , @NamedQuery(name = "Ordersdetail.findByQuatity", query = "SELECT o FROM Ordersdetail o WHERE o.quatity = :quatity")
    , @NamedQuery(name = "Ordersdetail.findByPrice", query = "SELECT o FROM Ordersdetail o WHERE o.price = :price")})
public class Ordersdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Orderdetail")
    private String idOrderdetail;
    @Column(name = "Quatity")
    private Integer quatity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;
    @JoinColumn(name = "Id_Order", referencedColumnName = "Id_Order")
    @ManyToOne
    private Orders idOrder;
    @JoinColumn(name = "Id_Product", referencedColumnName = "Id_Product")
    @ManyToOne
    private Product idProduct;

    public Ordersdetail() {
    }

    public Ordersdetail(String idOrderdetail) {
        this.idOrderdetail = idOrderdetail;
    }

    public String getIdOrderdetail() {
        return idOrderdetail;
    }

    public void setIdOrderdetail(String idOrderdetail) {
        this.idOrderdetail = idOrderdetail;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Orders getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Orders idOrder) {
        this.idOrder = idOrder;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderdetail != null ? idOrderdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordersdetail)) {
            return false;
        }
        Ordersdetail other = (Ordersdetail) object;
        if ((this.idOrderdetail == null && other.idOrderdetail != null) || (this.idOrderdetail != null && !this.idOrderdetail.equals(other.idOrderdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Ordersdetail[ idOrderdetail=" + idOrderdetail + " ]";
    }
    
}
