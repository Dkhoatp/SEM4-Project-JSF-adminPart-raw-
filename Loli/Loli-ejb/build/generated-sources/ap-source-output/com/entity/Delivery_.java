package com.entity;

import com.entity.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Delivery.class)
public class Delivery_ { 

    public static volatile SingularAttribute<Delivery, String> idDelivery;
    public static volatile SingularAttribute<Delivery, String> phone;
    public static volatile CollectionAttribute<Delivery, Orders> ordersCollection;
    public static volatile SingularAttribute<Delivery, String> addressDelivery;
    public static volatile SingularAttribute<Delivery, String> nameDelivery;
    public static volatile SingularAttribute<Delivery, String> email;

}