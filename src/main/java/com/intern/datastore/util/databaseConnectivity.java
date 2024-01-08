/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.intern.datastore.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author prasa
 */
public class databaseConnectivity {
     public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "SYSTEM", "SYSTEM");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
