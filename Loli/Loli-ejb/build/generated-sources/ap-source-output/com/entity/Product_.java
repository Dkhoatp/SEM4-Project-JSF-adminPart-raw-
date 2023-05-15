package com.entity;

import com.entity.Comment;
import com.entity.Images;
import com.entity.Ordersdetail;
import com.entity.ProductSaleOff;
import com.entity.Typex;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> quatity;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile CollectionAttribute<Product, Comment> commentCollection;
    public static volatile SingularAttribute<Product, Typex> idTypex;
    public static volatile SingularAttribute<Product, String> idProduct;
    public static volatile CollectionAttribute<Product, Ordersdetail> ordersdetailCollection;
    public static volatile CollectionAttribute<Product, ProductSaleOff> productSaleOffCollection;
    public static volatile CollectionAttribute<Product, Images> imagesCollection;
    public static volatile SingularAttribute<Product, String> productName;

}