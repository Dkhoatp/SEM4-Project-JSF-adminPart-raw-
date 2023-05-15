package com.entity;

import com.entity.Account;
import com.entity.AddressList;
import com.entity.Delivery;
import com.entity.Ordersdetail;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Account> idAccount;
    public static volatile SingularAttribute<Orders, String> idOrder;
    public static volatile SingularAttribute<Orders, Integer> statusOrder;
    public static volatile SingularAttribute<Orders, Integer> quatity;
    public static volatile SingularAttribute<Orders, Delivery> idDelivery;
    public static volatile SingularAttribute<Orders, BigDecimal> price;
    public static volatile SingularAttribute<Orders, AddressList> addressList;
    public static volatile SingularAttribute<Orders, Date> dateOrder;
    public static volatile CollectionAttribute<Orders, Ordersdetail> ordersdetailCollection;
    public static volatile SingularAttribute<Orders, Integer> stausPayment;

}