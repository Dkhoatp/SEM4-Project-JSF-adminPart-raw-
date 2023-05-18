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
@Table(name = "Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByIdAccount", query = "SELECT a FROM Account a WHERE a.idAccount = :idAccount")
    , @NamedQuery(name = "Account.findByFullname", query = "SELECT a FROM Account a WHERE a.fullname = :fullname")
    , @NamedQuery(name = "Account.findByRuleAccount", query = "SELECT a FROM Account a WHERE a.ruleAccount = :ruleAccount")
    , @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username")
    , @NamedQuery(name = "Account.findByPasswords", query = "SELECT a FROM Account a WHERE a.passwords = :passwords")
    , @NamedQuery(name = "Account.findByImages", query = "SELECT a FROM Account a WHERE a.images = :images")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByDateofbirth", query = "SELECT a FROM Account a WHERE a.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender")
    , @NamedQuery(name = "Account.findByStatusAccount", query = "SELECT a FROM Account a WHERE a.statusAccount = :statusAccount")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Account")
    private String idAccount;
    @Size(max = 255)
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "Rule_Account")
    private Integer ruleAccount;
    @Size(max = 50)
    @Column(name = "Username")
    private String username;
    @Size(max = 50)
    @Column(name = "Passwords")
    private String passwords;
    @Size(max = 255)
    @Column(name = "Images")
    private String images;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Column(name = "Dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Size(max = 50)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Status_Account")
    private Integer statusAccount;
    @OneToMany(mappedBy = "idAccount")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "idAccount")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "idAccount")
    private Collection<Historylogin> historyloginCollection;
    @OneToMany(mappedBy = "idAccount")
    private Collection<AddressList> addressListCollection;

    public Account() {
    }

    public Account(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getRuleAccount() {
        return ruleAccount;
    }

    public void setRuleAccount(Integer ruleAccount) {
        this.ruleAccount = ruleAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(Integer statusAccount) {
        this.statusAccount = statusAccount;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Historylogin> getHistoryloginCollection() {
        return historyloginCollection;
    }

    public void setHistoryloginCollection(Collection<Historylogin> historyloginCollection) {
        this.historyloginCollection = historyloginCollection;
    }

    @XmlTransient
    public Collection<AddressList> getAddressListCollection() {
        return addressListCollection;
    }

    public void setAddressListCollection(Collection<AddressList> addressListCollection) {
        this.addressListCollection = addressListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccount != null ? idAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idAccount == null && other.idAccount != null) || (this.idAccount != null && !this.idAccount.equals(other.idAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Account[ idAccount=" + idAccount + " ]";
    }
    
}
