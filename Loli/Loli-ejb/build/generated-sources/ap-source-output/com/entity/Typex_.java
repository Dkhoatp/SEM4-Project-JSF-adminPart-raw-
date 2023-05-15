package com.entity;

import com.entity.CategoryTypex;
import com.entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Typex.class)
public class Typex_ { 

    public static volatile SingularAttribute<Typex, String> nameTypex;
    public static volatile CollectionAttribute<Typex, CategoryTypex> categoryTypexCollection;
    public static volatile SingularAttribute<Typex, Integer> statusTypex;
    public static volatile CollectionAttribute<Typex, Product> productCollection;
    public static volatile SingularAttribute<Typex, String> idTypex;

}