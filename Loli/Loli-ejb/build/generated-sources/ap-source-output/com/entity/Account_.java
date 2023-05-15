package com.entity;

import com.entity.AddressList;
import com.entity.Comment;
import com.entity.Historylogin;
import com.entity.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> idAccount;
    public static volatile SingularAttribute<Account, Date> dateofbirth;
    public static volatile SingularAttribute<Account, String> images;
    public static volatile SingularAttribute<Account, String> gender;
    public static volatile CollectionAttribute<Account, Comment> commentCollection;
    public static volatile CollectionAttribute<Account, AddressList> addressListCollection;
    public static volatile CollectionAttribute<Account, Orders> ordersCollection;
    public static volatile SingularAttribute<Account, String> passwords;
    public static volatile SingularAttribute<Account, Integer> ruleAccount;
    public static volatile SingularAttribute<Account, Integer> statusAccount;
    public static volatile CollectionAttribute<Account, Historylogin> historyloginCollection;
    public static volatile SingularAttribute<Account, String> fullname;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;

}