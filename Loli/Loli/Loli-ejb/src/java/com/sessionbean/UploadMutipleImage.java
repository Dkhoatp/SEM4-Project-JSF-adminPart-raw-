/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.cloudinary.Cloudinary;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateful;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author nttha
 */
@Stateful
public class UploadMutipleImage implements UploadMutipleImageLocal {

    public static List<javax.servlet.http.Part> getAllParts(Part part) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());
    }

    private String changeFile(Part f) {
        String imagePath = null;
        if (f != null) {
            InputStream content = null;
            try {
                content = f.getInputStream();
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ec = context.getExternalContext();
                HttpServletRequest request = (HttpServletRequest) ec.getRequest();
                String applicationPath = request.getServletContext().getRealPath("");
                String uploadFilePath = applicationPath + File.separator + "resources";
                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                OutputStream outputStream = null;
                try {
                    File outputFilePath = new File(uploadFilePath + File.separator + f.getSubmittedFileName());
                    imagePath = uploadFilePath + File.separator + f.getSubmittedFileName();
                    content = f.getInputStream();
                    outputStream = new FileOutputStream(outputFilePath);
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = content.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    System.out.println("File uploaded successfully!");
                } catch (Exception ex) {
                    ex.toString();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(imagePath).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    content.close();
                } catch (IOException ex) {
                    Logger.getLogger(imagePath).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(imagePath);
        return imagePath;
    }

    @Override
    public List<String> uploadMutipleImage(Part file, String foder) {
        if (file != null) {
            List<String> listUrlImage = new ArrayList<>();
            try {
                for (Part part : getAllParts(file)) {
                    Map config = new HashMap<>();
                    config.put("cloud_name", "dkcfd8eib");
                    config.put("api_key", "221815591784587");
                    config.put("api_secret", "PhIjzVcnv7S6sRg9M0I7Hcg31NE");
                    Cloudinary cloudinary = new Cloudinary(config);
                    Map url = new HashMap();
                    Random random = new Random();
                    url.put("public_id", foder + Math.abs(random.nextLong()));
                    url.put("overwrite", true);
                    url.put("resource_type", "image");
                    Map r = cloudinary.uploader().upload(changeFile(part), url);
                    String imgurl = (String) r.get("secure_url");
                    System.out.println(imgurl);
                    listUrlImage.add(imgurl);
                }
            } catch (ServletException | IOException ex) {
                Logger.getLogger(UploadMutipleImage.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listUrlImage;
        }
        return null;
    }

}
