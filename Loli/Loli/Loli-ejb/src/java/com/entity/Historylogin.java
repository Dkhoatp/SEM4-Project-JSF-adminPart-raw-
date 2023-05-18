/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Historylogin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historylogin.findAll", query = "SELECT h FROM Historylogin h")
    , @NamedQuery(name = "Historylogin.findByIdHistory", query = "SELECT h FROM Historylogin h WHERE h.idHistory = :idHistory")
    , @NamedQuery(name = "Historylogin.findByDateTimes", query = "SELECT h FROM Historylogin h WHERE h.dateTimes = :dateTimes")})
public class Historylogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_History")
    private String idHistory;
    @Column(name = "DateTimes")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimes;
    @JoinColumn(name = "Id_Account", referencedColumnName = "Id_Account")
    @ManyToOne
    private Account idAccount;

    public Historylogin() {
    }

    public Historylogin(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public Date getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(Date dateTimes) {
        this.dateTimes = dateTimes;
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
        hash += (idHistory != null ? idHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historylogin)) {
            return false;
        }
        Historylogin other = (Historylogin) object;
        if ((this.idHistory == null && other.idHistory != null) || (this.idHistory != null && !this.idHistory.equals(other.idHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Historylogin[ idHistory=" + idHistory + " ]";
    }
    
}
