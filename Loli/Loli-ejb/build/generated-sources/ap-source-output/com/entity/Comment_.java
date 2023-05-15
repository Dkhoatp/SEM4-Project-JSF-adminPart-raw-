package com.entity;

import com.entity.Account;
import com.entity.ImageComment;
import com.entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T22:59:39")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> indexComment;
    public static volatile SingularAttribute<Comment, Account> idAccount;
    public static volatile CollectionAttribute<Comment, ImageComment> imageCommentCollection;
    public static volatile SingularAttribute<Comment, String> contents;
    public static volatile SingularAttribute<Comment, String> idcomment;
    public static volatile SingularAttribute<Comment, Product> idProduct;
    public static volatile SingularAttribute<Comment, Integer> evaluate;

}