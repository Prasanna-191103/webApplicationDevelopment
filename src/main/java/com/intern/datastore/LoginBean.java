/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore;

import java.io.Serializable;
import javax.annotation.ManagedBean;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;

//import com.intern.datastore.LoginDAO;
//import com.intern.datastore.SessionUtils;
/**
 *
 * @author prasa
 */
@ManagedBean
public class LoginBean implements Serializable {

    private int user_id;
    private String username;
    private String password;
    private int phone_no;
    private String place;
    private int pin;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
