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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AddressList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressList.findAll", query = "SELECT a FROM AddressList a")
    , @NamedQuery(name = "AddressList.findByIdAddressList", query = "SELECT a FROM AddressList a WHERE a.idAddressList = :idAddressList")
    , @NamedQuery(name = "AddressList.findByFullname", query = "SELECT a FROM AddressList a WHERE a.fullname = :fullname")
    , @NamedQuery(name = "AddressList.findByActivity", query = "SELECT a FROM AddressList a WHERE a.activity = :activity")
    , @NamedQuery(name = "AddressList.findByAddressinfo", query = "SELECT a FROM AddressList a WHERE a.addressinfo = :addressinfo")
    , @NamedQuery(name = "AddressList.findByPhone", query = "SELECT a FROM AddressList a WHERE a.phone = :phone")})
public class AddressList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_AddressList")
    private String idAddressList;
    @Size(max = 255)
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "Activity")
    private Integer activity;
    @Size(max = 255)
    @Column(name = "Address_info")
    private String addressinfo;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "addressList")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "Id_Account", referencedColumnName = "Id_Account")
    @ManyToOne
    private Account idAccount;

    public AddressList() {
    }

    public AddressList(String idAddressList) {
        this.idAddressList = idAddressList;
    }

    public String getIdAddressList() {
        return idAddressList;
    }

    public void setIdAddressList(String idAddressList) {
        this.idAddressList = idAddressList;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddressList != null ? idAddressList.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressList)) {
            return false;
        }
        AddressList other = (AddressList) object;
        if ((this.idAddressList == null && other.idAddressList != null) || (this.idAddressList != null && !this.idAddressList.equals(other.idAddressList))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.AddressList[ idAddressList=" + idAddressList + " ]";
    }
    
}
