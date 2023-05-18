/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;


import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.Part;

/**
 *
 * @author nttha
 */
@Local
public interface UploadMutipleImageLocal {
     public List<String> uploadMutipleImage(Part file , String foder);
}
