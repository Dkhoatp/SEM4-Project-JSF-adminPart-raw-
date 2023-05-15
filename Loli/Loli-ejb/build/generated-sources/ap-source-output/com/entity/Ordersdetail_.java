package com.entity;

import com.entity.Orders;
import com.entity.Product;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Ordersdetail.class)
public class Ordersdetail_ { 

    public static volatile SingularAttribute<Ordersdetail, Orders> idOrder;
    public static volatile SingularAttribute<Ordersdetail, Integer> quatity;
    public static volatile SingularAttribute<Ordersdetail, BigDecimal> price;
    public static volatile SingularAttribute<Ordersdetail, String> idOrderdetail;
    public static volatile SingularAttribute<Ordersdetail, Product> idProduct;

}