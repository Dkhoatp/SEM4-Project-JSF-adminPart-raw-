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
@Table(name = "Comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByIdcomment", query = "SELECT c FROM Comment c WHERE c.idcomment = :idcomment")
    , @NamedQuery(name = "Comment.findByEvaluate", query = "SELECT c FROM Comment c WHERE c.evaluate = :evaluate")
    , @NamedQuery(name = "Comment.findByContents", query = "SELECT c FROM Comment c WHERE c.contents = :contents")
    , @NamedQuery(name = "Comment.findByIndexComment", query = "SELECT c FROM Comment c WHERE c.indexComment = :indexComment")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_comment")
    private String idcomment;
    @Column(name = "Evaluate")
    private Integer evaluate;
    @Size(max = 1073741823)
    @Column(name = "Contents")
    private String contents;
    @Column(name = "indexComment")
    private Integer indexComment;
    @JoinColumn(name = "Id_Account", referencedColumnName = "Id_Account")
    @ManyToOne
    private Account idAccount;
    @JoinColumn(name = "Id_Product", referencedColumnName = "Id_Product")
    @ManyToOne
    private Product idProduct;
    @OneToMany(mappedBy = "idcomment")
    private Collection<ImageComment> imageCommentCollection;

    public Comment() {
    }

    public Comment(String idcomment) {
        this.idcomment = idcomment;
    }

    public String getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(String idcomment) {
        this.idcomment = idcomment;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getIndexComment() {
        return indexComment;
    }

    public void setIndexComment(Integer indexComment) {
        this.indexComment = indexComment;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @XmlTransient
    public Collection<ImageComment> getImageCommentCollection() {
        return imageCommentCollection;
    }

    public void setImageCommentCollection(Collection<ImageComment> imageCommentCollection) {
        this.imageCommentCollection = imageCommentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomment != null ? idcomment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.idcomment == null && other.idcomment != null) || (this.idcomment != null && !this.idcomment.equals(other.idcomment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Comment[ idcomment=" + idcomment + " ]";
    }
    
}
