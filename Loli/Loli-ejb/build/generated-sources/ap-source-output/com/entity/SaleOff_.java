package com.entity;

import com.entity.ProductSaleOff;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(SaleOff.class)
public class SaleOff_ { 

    public static volatile SingularAttribute<SaleOff, String> salename;
    public static volatile SingularAttribute<SaleOff, Date> enddate;
    public static volatile SingularAttribute<SaleOff, String> idSale;
    public static volatile SingularAttribute<SaleOff, Integer> discount;
    public static volatile CollectionAttribute<SaleOff, ProductSaleOff> productSaleOffCollection;
    public static volatile SingularAttribute<SaleOff, Date> startdate;

}