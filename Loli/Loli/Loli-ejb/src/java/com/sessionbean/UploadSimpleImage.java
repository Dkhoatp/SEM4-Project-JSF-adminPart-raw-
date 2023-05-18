/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import javax.ejb.Stateful;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author nttha
 */
@Stateful
public class UploadSimpleImage implements UploadSimpleImageLocal {

    @Override
    public String uploadFile(Part file, String forder) {
        if (file != null) {
            Map config = new HashMap<>();
            config.put("cloud_name", "dgqpflpp6");
            config.put("api_key", "426899457594745");
            config.put("api_secret", "c2aa-P15o2mKviEecqJBtsBwRxc");
            Cloudinary cloudinary = new Cloudinary(config);
            Map url = new HashMap();
            url.put("public_id", forder);
            url.put("overwrite", true);
            url.put("resource_type", "image");
            try {
                Map r = cloudinary.uploader().upload(changeFile(file), url);
                String imgurl = (String) r.get("secure_url");
                return imgurl;
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return null;
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
    public void delete(String urlImage) {
        Map config = new HashMap<>();
        config.put("cloud_name", "dgqpflpp6");
        config.put("api_key", "426899457594745");
        config.put("api_secret", "c2aa-P15o2mKviEecqJBtsBwRxc");

        Cloudinary cloudinary = new Cloudinary(config);

        try {
            Map result = cloudinary.uploader().destroy(urlImage, ObjectUtils.emptyMap());
            System.out.println(result);
        } catch (IOException ex) {
        }

    }

    @Override
    public String extractPublicId(String url) {
        int startIndex = url.lastIndexOf("upload");
        int endIndex = url.lastIndexOf(".");
        String publicId = url.substring(startIndex, endIndex);
        String[] parts = publicId.split("/");
        return parts.length >= 3
                ? Arrays.stream(parts, 2, parts.length)
                        .collect(Collectors.joining("/")) : "";
    }

}
