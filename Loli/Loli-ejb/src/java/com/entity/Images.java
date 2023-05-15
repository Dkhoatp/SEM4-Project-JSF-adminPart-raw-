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
@Table(name = "Images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i")
    , @NamedQuery(name = "Images.findByIdImage", query = "SELECT i FROM Images i WHERE i.idImage = :idImage")
    , @NamedQuery(name = "Images.findByUrlImage", query = "SELECT i FROM Images i WHERE i.urlImage = :urlImage")
    , @NamedQuery(name = "Images.findByActivity", query = "SELECT i FROM Images i WHERE i.activity = :activity")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Image")
    private String idImage;
    @Size(max = 255)
    @Column(name = "Url_Image")
    private String urlImage;
    @Column(name = "Activity")
    private Integer activity;
    @JoinColumn(name = "Id_Product", referencedColumnName = "Id_Product")
    @ManyToOne
    private Product idProduct;

    public Images() {
    }

    public Images(String idImage) {
        this.idImage = idImage;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
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
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Images[ idImage=" + idImage + " ]";
    }
    
}
