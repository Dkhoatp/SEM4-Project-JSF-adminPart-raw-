/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByIdOrder", query = "SELECT o FROM Orders o WHERE o.idOrder = :idOrder")
    , @NamedQuery(name = "Orders.findByQuatity", query = "SELECT o FROM Orders o WHERE o.quatity = :quatity")
    , @NamedQuery(name = "Orders.findByDateOrder", query = "SELECT o FROM Orders o WHERE o.dateOrder = :dateOrder")
    , @NamedQuery(name = "Orders.findByStausPayment", query = "SELECT o FROM Orders o WHERE o.stausPayment = :stausPayment")
    , @NamedQuery(name = "Orders.findByStatusOrder", query = "SELECT o FROM Orders o WHERE o.statusOrder = :statusOrder")
    , @NamedQuery(name = "Orders.findByPrice", query = "SELECT o FROM Orders o WHERE o.price = :price")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Order")
    private String idOrder;
    @Column(name = "Quatity")
    private Integer quatity;
    @Column(name = "DateOrder")
    @Temporal(TemporalType.DATE)
    private Date dateOrder;
    @Column(name = "Staus_Payment")
    private Integer stausPayment;
    @Column(name = "Status_Order")
    private Integer statusOrder;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;
    @OneToMany(mappedBy = "idOrder")
    private Collection<Ordersdetail> ordersdetailCollection;
    @JoinColumn(name = "Id_Account", referencedColumnName = "Id_Account")
    @ManyToOne
    private Account idAccount;
    @JoinColumn(name = "AddressList", referencedColumnName = "Id_AddressList")
    @ManyToOne
    private AddressList addressList;
    @JoinColumn(name = "Id_Delivery", referencedColumnName = "Id_Delivery")
    @ManyToOne
    private Delivery idDelivery;

    public Orders() {
    }

    public Orders(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Integer getStausPayment() {
        return stausPayment;
    }

    public void setStausPayment(Integer stausPayment) {
        this.stausPayment = stausPayment;
    }

    public Integer getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Integer statusOrder) {
        this.statusOrder = statusOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Ordersdetail> getOrdersdetailCollection() {
        return ordersdetailCollection;
    }

    public void setOrdersdetailCollection(Collection<Ordersdetail> ordersdetailCollection) {
        this.ordersdetailCollection = ordersdetailCollection;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    public AddressList getAddressList() {
        return addressList;
    }

    public void setAddressList(AddressList addressList) {
        this.addressList = addressList;
    }

    public Delivery getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Delivery idDelivery) {
        this.idDelivery = idDelivery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orders[ idOrder=" + idOrder + " ]";
    }
    
}
