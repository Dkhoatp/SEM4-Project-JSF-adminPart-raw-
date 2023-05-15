/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import com.entity.Typex;
import com.sessionbean.RandomLocal;
import com.sessionbean.TypexFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Admin
 */
@Named(value = "typexMB")
@RequestScoped
public class TypexMB {

    @EJB
    private RandomLocal random;

    @EJB
    private TypexFacadeLocal typexFacade;

    private Typex typex;
    private String typexID;
    private List<Typex> typexList;

    public TypexMB() {
        typex = new Typex();
    }

    public String createTypex() {
        typex.setStatusTypex(1);
        typex.setIdTypex(random.randomcode(10));
        typexFacade.create(typex);
        typex = new Typex();
        typexList = typexFacade.findActive();
        return "TypexCreateSuccess";
    }

    public String editTypex(Typex t) {
        typex = t;
        return "/admin/type/edit";
    }

    public String deleteActiveTypex(Typex t) {
        typex = t;
        typexFacade.find(typex.getIdTypex());
        typex.setStatusTypex(0);
        typexFacade.edit(typex);
        typex = new Typex();
        typexList = typexFacade.findActive();
        return "/admin/type/manage?faces-redirect=true";
    }

    public String restoreActiveTypex(Typex t) {
        typex = t;
        typexFacade.find(typex.getIdTypex());
        typex.setStatusTypex(1);
        typexFacade.edit(typex);
        typex = new Typex();
        typexList = typexFacade.findActive();
        return "/admin/type/recycleBin?faces-redirect=true";
    }
    public List<Typex> showRestoreTypex() {
        return typexList = typexFacade.findHidden();
    }

    public String updateTypex() {
        typexFacade.edit(typex);
        typex = new Typex();
        typexList = typexFacade.findActive();
        return "TypexEditSuccess";
    }

    public List<Typex> showTypex() {
        return typexList = typexFacade.findActive();
    }

    public Typex getTypex() {
        return typex;
    }

    public void setTypex(Typex typex) {
        this.typex = typex;
    }

    public String getTypexID() {
        return typexID;
    }

    public void setTypexID(String typexID) {
        this.typexID = typexID;
    }

    public List<Typex> getTypexList() {
        return typexList;
    }

    public void setTypexList(List<Typex> typexList) {
        this.typexList = typexList;
    }

}
