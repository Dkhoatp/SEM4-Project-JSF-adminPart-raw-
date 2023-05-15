package com.entity;

import com.entity.BrandCategory;
import com.entity.CategoryTypex;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, BrandCategory> brandCategoryCollection;
    public static volatile CollectionAttribute<Category, CategoryTypex> categoryTypexCollection;
    public static volatile SingularAttribute<Category, String> nameCategory;
    public static volatile SingularAttribute<Category, Integer> statusCategory;
    public static volatile SingularAttribute<Category, String> idCategory;

}