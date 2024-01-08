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
public class UpdateDAO {
     public static boolean validate2(String place,int pin) throws SQLException {
		Connection con =  databaseConnectivity.getConnection();
                try{
                    String sql=" update users set place=? where pin=?";
                    PreparedStatement ps1=con.prepareCall(sql);
                    ps1.setString(1,"block");
                    ps1.setInt(2, 607308);
                    ps1.executeQuery();
                    ResultSet rs = ps1.executeQuery();
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

    public static boolean validate3(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

