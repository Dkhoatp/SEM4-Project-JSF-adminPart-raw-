/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.ImageComment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface ImageCommentFacadeLocal {

    void create(ImageComment imageComment);

    void edit(ImageComment imageComment);

    void remove(ImageComment imageComment);

    ImageComment find(Object id);

    List<ImageComment> findAll();

    List<ImageComment> findRange(int[] range);

    int count();
    
}
