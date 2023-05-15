package com.entity;

import com.entity.BrandCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile CollectionAttribute<Brand, BrandCategory> brandCategoryCollection;
    public static volatile SingularAttribute<Brand, String> images;
    public static volatile SingularAttribute<Brand, Integer> statusBrand;
    public static volatile SingularAttribute<Brand, String> idBrand;
    public static volatile SingularAttribute<Brand, String> nameBrand;

}