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

public class UserCls implements Serializable {

    private LoginBean lbnn = new LoginBean();

    public LoginBean getLbnn() {
        return lbnn;
    }

    public void setLbnn(LoginBean lbnn) {
        this.lbnn = lbnn;
    }

    private List<LoginBean> perInfoAll;


        public List<LoginBean> getPerInfoAll() {
            return perInfoAll;
        }

        public void setPerInfoAll(List<LoginBean> perInfoAll) {
            this.perInfoAll = perInfoAll;
        }

    @PostConstruct
    public void init() {
        display();
    }


    public String submit() throws Exception {
        boolean validu = UserDAO.validate1(lbnn.getUser_id(), lbnn.getUsername(), lbnn.getPassword(), lbnn.getPhone_no(), lbnn.getPlace(), lbnn.getPin());
        if (validu) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String update() throws Exception {
        boolean validu = UpdateDAO.validate2(lbnn.getPlace(), lbnn.getPin());
        if (validu) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String delete() throws Exception {
        boolean validu = DeleteDAO.validate3(lbnn.getUsername());
        if (validu) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void display() {
            DisplayDAO userService = new DisplayDAO();
            perInfoAll = userService.getperInfoAll();
            PrimeFaces.current().ajax().update("", "form:dt-products");
    }
}
