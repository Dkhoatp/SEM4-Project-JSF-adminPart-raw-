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
@Table(name = "Delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findByIdDelivery", query = "SELECT d FROM Delivery d WHERE d.idDelivery = :idDelivery")
    , @NamedQuery(name = "Delivery.findByNameDelivery", query = "SELECT d FROM Delivery d WHERE d.nameDelivery = :nameDelivery")
    , @NamedQuery(name = "Delivery.findByPhone", query = "SELECT d FROM Delivery d WHERE d.phone = :phone")
    , @NamedQuery(name = "Delivery.findByEmail", query = "SELECT d FROM Delivery d WHERE d.email = :email")
    , @NamedQuery(name = "Delivery.findByAddressDelivery", query = "SELECT d FROM Delivery d WHERE d.addressDelivery = :addressDelivery")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Delivery")
    private String idDelivery;
    @Size(max = 100)
    @Column(name = "Name_Delivery")
    private String nameDelivery;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Size(max = 1073741823)
    @Column(name = "Address_Delivery")
    private String addressDelivery;
    @OneToMany(mappedBy = "idDelivery")
    private Collection<Orders> ordersCollection;

    public Delivery() {
    }

    public Delivery(String idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(String idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getNameDelivery() {
        return nameDelivery;
    }

    public void setNameDelivery(String nameDelivery) {
        this.nameDelivery = nameDelivery;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelivery != null ? idDelivery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.idDelivery == null && other.idDelivery != null) || (this.idDelivery != null && !this.idDelivery.equals(other.idDelivery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Delivery[ idDelivery=" + idDelivery + " ]";
    }
    
}
