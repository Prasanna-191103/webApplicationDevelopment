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
public class DeleteDAO {
        public static boolean validate3(String username) throws SQLException {
            Connection con =  databaseConnectivity.getConnection();
            try{
                 String sql=" delete from users where username=?";
                 PreparedStatement ps2=con.prepareCall(sql);
                 ps2.setString(1,"prasanna");
                 ps2.executeQuery();
            ResultSet rs = ps2.executeQuery();
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
