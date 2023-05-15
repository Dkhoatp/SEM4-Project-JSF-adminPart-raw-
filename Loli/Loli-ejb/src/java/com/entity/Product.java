/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName")
    , @NamedQuery(name = "Product.findByQuatity", query = "SELECT p FROM Product p WHERE p.quatity = :quatity")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_Product")
    private String idProduct;
    @Size(max = 50)
    @Column(name = "Product_Name")
    private String productName;
    @Column(name = "Quatity")
    private Integer quatity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;
    @OneToMany(mappedBy = "idProduct")
    private Collection<Ordersdetail> ordersdetailCollection;
    @OneToMany(mappedBy = "idProduct")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "idProduct")
    private Collection<Images> imagesCollection;
    @JoinColumn(name = "Id_Typex", referencedColumnName = "Id_Typex")
    @ManyToOne
    private Typex idTypex;
    @OneToMany(mappedBy = "idProduct")
    private Collection<ProductSaleOff> productSaleOffCollection;

    public Product() {
    }

    public Product(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    @XmlTransient
    public Collection<Ordersdetail> getOrdersdetailCollection() {
        return ordersdetailCollection;
    }

    public void setOrdersdetailCollection(Collection<Ordersdetail> ordersdetailCollection) {
        this.ordersdetailCollection = ordersdetailCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public Typex getIdTypex() {
        return idTypex;
    }

    public void setIdTypex(Typex idTypex) {
        this.idTypex = idTypex;
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
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Product[ idProduct=" + idProduct + " ]";
    }
    
}
