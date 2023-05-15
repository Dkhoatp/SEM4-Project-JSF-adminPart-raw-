package com.entity;

import com.entity.Brand;
import com.entity.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(BrandCategory.class)
public class BrandCategory_ { 

    public static volatile SingularAttribute<BrandCategory, Brand> idBrand;
    public static volatile SingularAttribute<BrandCategory, String> idCategoryBrand;
    public static volatile SingularAttribute<BrandCategory, Category> idCategory;

}