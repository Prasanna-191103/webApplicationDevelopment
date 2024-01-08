/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore.dao;

import com.intern.datastore.util.databaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author prasa
 */
public class UserDAO {
    public static boolean validate1(int user_id,String username, String password,int phone_no,String place,int pin) throws SQLException {
                
		Connection con =  databaseConnectivity.getConnection();
		//PreparedStatement ps = null;	
                try{
                    String sql=" INSERT into users(user_id,username,password,phone_no,place,pin) values(?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1,user_id);
                    ps.setString(2, username);
                    ps.setString(3, password);
                    ps.setInt(4, phone_no);
                    ps.setString(5, place);
                    ps.setInt(6,pin);
                    
                    ps.executeQuery();
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                    return true;
                    }
                }
            catch (SQLException ex)
            {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
            }
                finally 
                {
			databaseConnectivity.close(con);
		}
                return false;
    }
}
