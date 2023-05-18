/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Brand;
import com.entity.Typex;
import com.entity.Product;
import com.entity.Category;
import com.entity.Images;
import com.sessionbean.BrandCategoryFacadeLocal;
import com.sessionbean.BrandFacadeLocal;
import com.sessionbean.CategoryFacadeLocal;
import com.sessionbean.CategoryTypexFacadeLocal;
import com.sessionbean.ImagesFacadeLocal;
import com.sessionbean.ProductFacadeLocal;
import com.sessionbean.RandomLocal;
import com.sessionbean.TypexFacadeLocal;
import com.sessionbean.UploadMutipleImageLocal;
import com.sessionbean.UploadSimpleImageLocal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@Named(value = "productMB")
@RequestScoped
public class productMB {

    @EJB
    private RandomLocal random;

    @EJB
    private ImagesFacadeLocal imagesFacade;

    @EJB
    private UploadMutipleImageLocal uploadMutipleImage;

    @EJB
    private UploadSimpleImageLocal uploadSimpleImage;

    @EJB
    private BrandCategoryFacadeLocal brandCategoryFacade;

    @EJB
    private CategoryTypexFacadeLocal categoryTypexFacade;

    @EJB
    private TypexFacadeLocal typexFacade;

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private BrandFacadeLocal brandFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    private String idProduct;
    private Images imagesObj;
    List<Product> productList;
    private Product product;
    private Part images;
    private Part image;
    private final Map<String, List<Typex>> dataType = new HashMap<>();
    private final Map<String, List<Category>> dataCaterory = new HashMap<>();
    private String typex;
    private String caterory;
    private String brand;
    private List<Typex> typeList;
    private List<Category> categoryList;
    private List<Brand> brandList;
    private String categoryCheck = "none";
    private String typeCheck = "none";

    @PostConstruct
    public void init() {
        product = new Product();
        brandList = brandFacade.findActive();
        typeList = typexFacade.findActive();
        categoryList = categoryFacade.findActive();
        brandFacade.findActive().forEach(brands -> {
            List<Category> map = brandCategoryFacade.findAll()
                    .stream()
                    .filter(brandCategory -> brands.getIdBrand().equals(brandCategory.getIdBrand().getIdBrand()))
                    .map(brandCategory -> brandCategory.getIdCategory())
                    .collect(Collectors.toList());
            dataCaterory.put(brands.getIdBrand(), map);
        });
        categoryFacade.findActive().forEach(caterorys -> {
            List<Typex> map = categoryTypexFacade.findAll()
                    .stream()
                    .filter(categoryTypex -> caterorys.getIdCategory().equals(categoryTypex.getIdCategory().getIdCategory()))
                    .map(categoryTypex -> categoryTypex.getIdTypex())
                    .collect(Collectors.toList());
            dataType.put(caterorys.getIdCategory(), map);
        });
    }

    public List<Product> showProduct() {
        return productList = productFacade.findActive();

    }

    public void onCategoryChange() {
        categoryCheck = "block";
        typeCheck = "none";

        categoryList = Optional.ofNullable(brand)
                .filter(b -> !"".equals(b))
                .map(dataCaterory::get)
                .orElseGet(ArrayList::new);

    }

    public void onTypeChange() {
        typeCheck = "block";
        typeList = Optional.ofNullable(caterory)
                .filter(c -> !"".equals(c))
                .map(dataType::get)
                .orElseGet(ArrayList::new);
    }

    public String urlImage(String idProduct) {
        return imagesFacade.findAll().stream()
                .filter(images -> images.getIdProduct().getIdProduct() == idProduct && images.getActivity() == 1)
                .findFirst()
                .map(Images::getUrlImage)
                .orElse("https://res.cloudinary.com/dkcfd8eib/image/upload/v1681977616/Java/InstrumentStore/Product/defaultimageproduct_sj4ham.svg");
    }

    public String createProduct() {
        product.setIdProduct(random.randomcode(10));
        product.setIdTypex(typexFacade.find(typex));
        productFacade.create(product);
        Images imageObj = new Images();
        imageObj.setIdImage(random.randomcode(10));
        imageObj.setIdProduct(product);
        imageObj.setUrlImage(uploadSimpleImage.uploadFile(image, "Java/InstrumentStore/Product/" + product.getIdProduct() + "/" + imageObj.getIdImage()));
        imageObj.setActivity(1);
        imagesFacade.create(imageObj);
        try {
            uploadMutipleImage.uploadMutipleImage(images, "Java/InstrumentStore/Product/" + product.getIdProduct() + "/" + random.randomcode(10)).stream().map((imageUrl) -> {
                Images imageObjs = new Images();
                imageObjs.setIdImage(random.randomcode(10));
                imageObjs.setIdProduct(product);
                imageObjs.setUrlImage(imageUrl);
                imageObjs.setActivity(0);
                return imageObjs;
            }).forEachOrdered((imageObjs) -> {
                imagesFacade.create(imageObjs);
            });

            product = new Product();
        } catch (NullPointerException e) {

        }
        return "CreateProductSuccess";
    }

    public String updateProduct(Product p) {
        product = p;
        return "/admin/product/edit";
    }

    public String saveProduct() {
        Product p = productFacade.find(product.getIdProduct());
        p.setProductName(product.getProductName());
        p.setPrice(product.getPrice());
        p.setQuatity(product.getQuatity());
        productFacade.edit(p);
        product = new Product();
        return "SaveProductSuccess";
    }

    public String deleteProduct(Product p) {
        product = p;
        productFacade.find(product.getIdProduct());
        product.setQuatity(0);
        productFacade.edit(product);
        product = new Product();
        productList = productFacade.findActive();
        return "/admin/product/manage?faces-redirect=true";
    }

    public String restoreProduct(Product p) {
        product = p;
        productFacade.find(product.getIdProduct());
        product.setQuatity(1);
        productFacade.edit(product);
        product = new Product();
        productList = productFacade.findActive();
        return "/admin/product/recycleBin?faces-redirect=true";
    }

    //Image
    public String showIamgeProduct(Product p) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("idProduct", p.getIdProduct());
        return "/admin/product/imageProduct";
    }

    public List<Images> showIamges(String id) {
        return imagesFacade.showImageAll(id);
    }

    public String eiditImage(Images i) {
        imagesObj = i;
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("idImage", imagesObj.getIdImage());
        return "/admin/product/editimage";
    }

    public String updateImage(String idimge) {
        Optional.ofNullable(image).ifPresent(image -> {
            Images i = imagesFacade.find(idimge);
            i.setUrlImage(uploadSimpleImage.uploadFile(image, uploadSimpleImage.extractPublicId(i.getUrlImage())));
            imagesFacade.edit(i);
        });

        return "/admin/product/imageProduct";
    }

    public String checkMainImage(Images imgCheck) {
        return Optional.of(imgCheck).filter(img -> img.getActivity() == 1).map(img -> "block").orElse("none");
    }

    public String checkDeleteImage(Images imgCheck) {
        return Optional.of(imgCheck).filter(img -> img.getActivity() == 1).map(img -> "true").orElse("false");
    }

    public String createImage(String idProduct) {
        Images i = new Images();
        i.setActivity(0);
        i.setIdImage(random.randomcode(10));
        i.setIdProduct(productFacade.find(idProduct));

        Optional.ofNullable(image).map(img -> {
            i.setUrlImage(uploadSimpleImage.uploadFile(img, "Java/InstrumentStore/Product/" + idProduct + "/" + i.getIdImage()));
            return i;
        }).orElseGet(() -> {
            i.setIdImage("https://res.cloudinary.com/dkcfd8eib/image/upload/v1681977616/Java/InstrumentStore/Product/defaultimageproduct_sj4ham.svg");
            return i;
        });
        imagesFacade.create(i);
        return "/admin/product/imageProduct";
    }

    public void setActivity(Images setimge) {
        for (Images imgObj : imagesFacade.showImageAll(setimge.getIdProduct().getIdProduct())) {
            if (imgObj.getActivity() == 1) {
                imgObj.setActivity(0);
                imagesFacade.edit(imgObj);
            }
        }
        setimge.setActivity(1);
        imagesFacade.edit(setimge);
    }

    public void deleteImage(Images deleteimge) {
        uploadSimpleImage.delete(uploadSimpleImage.extractPublicId(deleteimge.getUrlImage()));
        imagesFacade.remove(deleteimge);
    }

    public List<Product> showRestoreProduct() {
        return productList = productFacade.findHidden();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Part getImages() {
        return images;
    }

    public void setImages(Part images) {
        this.images = images;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String getCaterory() {
        return caterory;
    }

    public void setCaterory(String caterory) {
        this.caterory = caterory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Typex> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Typex> typeList) {
        this.typeList = typeList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public String getCategoryCheck() {
        return categoryCheck;
    }

    public void setCategoryCheck(String categoryCheck) {
        this.categoryCheck = categoryCheck;
    }

    public String getTypeCheck() {
        return typeCheck;
    }

    public void setTypeCheck(String typeCheck) {
        this.typeCheck = typeCheck;
    }

    public String getTypex() {
        return typex;
    }

    public void setTypex(String typex) {
        this.typex = typex;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public Images getImagesObj() {
        return imagesObj;
    }

    public void setImagesObj(Images imagesObj) {
        this.imagesObj = imagesObj;
    }

}
