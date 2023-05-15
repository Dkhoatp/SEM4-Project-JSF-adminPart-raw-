package com.entity;

import com.entity.Account;
import com.entity.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(AddressList.class)
public class AddressList_ { 

    public static volatile SingularAttribute<AddressList, Account> idAccount;
    public static volatile SingularAttribute<AddressList, String> addressinfo;
    public static volatile SingularAttribute<AddressList, Integer> activity;
    public static volatile SingularAttribute<AddressList, String> phone;
    public static volatile SingularAttribute<AddressList, String> idAddressList;
    public static volatile SingularAttribute<AddressList, String> fullname;
    public static volatile CollectionAttribute<AddressList, Orders> ordersCollection;

}