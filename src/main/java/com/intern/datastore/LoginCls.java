/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore;

import com.intern.datastore.dao.DeleteDAO;
import com.intern.datastore.dao.DisplayDAO;
import com.intern.datastore.dao.LoginDAO;
import com.intern.datastore.dao.UserDAO;
import com.intern.datastore.dao.UpdateDAO;
import java.io.Serializable;
import java.util.List;

//import javax.faces.application.FacesMessage;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
//import javax.enterprise.context.SessionScoped;

import org.primefaces.PrimeFaces;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;

//import com.intern.datastore.LoginDAO;
//import com.intern.datastore.SessionUtils;
/**
 *
 * @author prasa
 */
@ManagedBean
@SessionScoped

public class LoginCls implements Serializable {

    private LoginBean lbn;

    private List<LoginBean> perInfoAll;

    public LoginBean getLbn() {
        if (lbn == null) {
            lbn = new LoginBean();
        }
        return lbn;
    }

    public void setLbn(LoginBean lbn) {
        this.lbn = lbn;
    }

    public List<LoginBean> getPerInfoAll() {
        return perInfoAll;
    }

    public void setPerInfoAll(List<LoginBean> perInfoAll) {
        this.perInfoAll = perInfoAll;
    }

//    @PostConstruct
//    public void init() {
//        display();
//    }

    public String login() throws Exception {

        boolean valid = LoginDAO.validate(lbn.getUser_id(), lbn.getPassword());
        if (valid) {
            return "success";
        } else {
            return "failure";
        }
    }

//    public String submit() throws Exception {
//        boolean validu = UserDAO.validate1(lbn.getUser_id(), lbn.getUsername(), lbn.getPassword(), lbn.getPhone_no(), lbn.getPlace(), lbn.getPin());
//        if (validu) {
//            return "success";
//        } else {
//            return "failure";
//        }
//    }
//
//    public String update() throws Exception {
//        boolean validu = UpdateDAO.validate2(lbn.getPlace(), lbn.getPin());
//        if (validu) {
//            return "success";
//        } else {
//            return "failure";
//        }
//    }
//
//    public String delete() throws Exception {
//        boolean validu = DeleteDAO.validate3(lbn.getUsername());
//        if (validu) {
//            return "success";
//        } else {
//            return "failure";
//        }
//    }
//
//    public void display() {
//        if (perInfoAll == null) {
//            DisplayDAO userService = new DisplayDAO();
//            perInfoAll = userService.getperInfoAll();
//            PrimeFaces.current().ajax().update("", "form:dt-products");
//        }
//    }
}
