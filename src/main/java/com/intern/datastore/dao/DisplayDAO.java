/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore.dao;

import com.intern.datastore.LoginBean;
import com.intern.datastore.util.databaseConnectivity;
import java.sql.*;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author prasa
 */
@ManagedBean
@ViewScoped

public class DisplayDAO {

    Connection con;
    Statement ps;
    ResultSet rs;
    private List<LoginBean> perInfoAll;

    public List<LoginBean> getperInfoAll() {
        int i = 0;
        Connection con = databaseConnectivity.getConnection();
        try {
            ps = con.createStatement();
            rs = ps.executeQuery("Select * from users");
            
            perInfoAll = new ArrayList();
            LoginBean lb;
            while (rs.next()) {
                // System.out.println(rs.getString(1));
                lb = new LoginBean();
                lb.setUser_id(rs.getInt("user_id"));
                lb.setUsername(rs.getString("username"));
                lb.setPassword(rs.getString("password"));
                lb.setPhone_no(rs.getInt("phone_no"));
                lb.setPlace(rs.getString("place"));
                lb.setPin(rs.getInt("pin"));
                perInfoAll.add(lb);
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error Data : " + e.getMessage());
        }
        return perInfoAll;
    }
}



//public class perInfo {
//
//private final int user_id;
//private final String username;
//private final String password;
//private final int phone_no;
//private final String place;
//private final int pin;
//
//
//
//public perInfo(int user_id,String username,String password,int phone_no,String place,int pin) {
//this.user_id = user_id;
//this.username = username;
//this.password = password;
//this.phone_no = phone_no;
//this.place= place;
//this.pin=pin;
//}
//
//public int getuser_id() {
//return user_id;
//}
//
//public String getusername() {
//return username;
//}
//
//public String getpassword() {
//return password;
//}
//
//public int getPhone_no() {
//return phone_no;
//}
//
//public String getPlace() {
//return place;
//}
//
//public int getPin() {
//return pin;
//}
//
//}
//

