/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Brand;
import com.sessionbean.BrandFacadeLocal;
import com.sessionbean.RandomLocal;
import com.sessionbean.UploadSimpleImageLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@Named(value = "brandMB")
@RequestScoped
public class BrandMB {

    @EJB
    private UploadSimpleImageLocal uploadSimpleImage;

    @EJB
    private RandomLocal random;

    @EJB
    private BrandFacadeLocal brandFacade;

    private Brand brand;
    private List<Brand> brandList;
    private Part image;

    public BrandMB() {
        brand = new Brand();
    }

    public String createBrand() {
        brand.setStatusBrand(1);
        brand.setIdBrand(random.randomcode(10));
        brand.setImages(uploadSimpleImage.uploadFile(image, "Java/InstrumentStore/brand/" + brand.getIdBrand()));
        if(image == null){
            brand.setImages("https://res.cloudinary.com/dkcfd8eib/image/upload/v1681977616/Java/InstrumentStore/Product/defaultimageproduct_sj4ham.svg");
        }
        brandFacade.create(brand);
        brand = new Brand();
        brandList = brandFacade.findActive();

        return "/admin/brand/manage?faces-redirect=true";
    }

    public String editBrand(Brand c) {
        brand = c;
        return "/admin/brand/edit";
    }

    public String updateBrand() {
        Brand b = brandFacade.find(brand.getIdBrand());
        brand.setImages(uploadSimpleImage.uploadFile(image, uploadSimpleImage.extractPublicId(b.getImages())));
        if(image == null){
            brand.setImages(b.getImages());
        }
        brandFacade.edit(brand);
        brand = new Brand();
        brandList = brandFacade.findActive();
        return "BrandEditSuccess";
    }

    public String deleteActiveBrand(Brand c) {
        brand = c;
        brandFacade.find(brand.getIdBrand());
        brand.setStatusBrand(0);
        brandFacade.edit(brand);
        brand = new Brand();
        brandList = brandFacade.findActive();
        return "/admin/brand/manage?faces-redirect=true";
    }
    public String restoreActiveBrand(Brand c) {
        brand = c;
        brandFacade.find(brand.getIdBrand());
        brand.setStatusBrand(1);
        brandFacade.edit(brand);
        brand = new Brand();
        brandList = brandFacade.findActive();
        return "/admin/brand/recycleBin?faces-redirect=true";
    }

    public void deleteBrand(Brand b) {
        uploadSimpleImage.delete(uploadSimpleImage.extractPublicId(b.getImages()));
        brandFacade.remove(b);
        brandList = brandFacade.findActive();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        String redirectURL = externalContext.getRequestContextPath() + "/faces/admin/brand/manage.xhtml?faces-redirect=true";
        try {
            externalContext.redirect(redirectURL);
        } catch (IOException ex) {
            Logger.getLogger(BrandMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Brand> showBrand() {
        return brandList = brandFacade.findActive();
    }
    public List<Brand> showRestoreBrand() {
        return brandList = brandFacade.findHidden();
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

}
