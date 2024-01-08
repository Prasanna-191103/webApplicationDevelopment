/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore.dao;

/**
 *
 * @author prasa
 */
import com.intern.datastore.util.databaseConnectivity;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author prasa
 */
public class LoginDAO {
    public static boolean validate(int user_id, String password) throws SQLException {
                
		Connection con =  databaseConnectivity.getConnection();
		PreparedStatement ps = null;
                try {			
                        String sql=" Select user_id, password from users where user_id =? and password =?";
                        ps = con.prepareStatement(sql);
                        ps.setInt(1, user_id);
                        ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			databaseConnectivity.close(con);
		}
		return false;
    }

//    public static boolean validate1(int user_id, String username, String password, int phone_no, String place, int pin) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
    

