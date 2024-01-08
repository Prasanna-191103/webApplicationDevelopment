package com.intern.datastore.dao;


import com.intern.datastore.util.databaseConnectivity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prasa
 */
public class FileuploadDAO  {
     public static boolean saveFile(int userId, UploadedFile fileData,String file_format) throws SQLException, IOException {
          Connection con =  databaseConnectivity.getConnection();
            try {
                String sql = "INSERT INTO files (USER_ID, FILE_NAME, FILEDATA, FILE_FORMAT) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setString(2, fileData.getFileName());
                ps.setBytes(3, fileData.getInputStream().readAllBytes());
                ps.setString(4, FilenameUtils.getExtension(fileData.getFileName()));
                ps.executeQuery();
            }
           catch (SQLException ex)
            {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
            }
            return true;
        }
     

    private static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return "";
        }
        return fileName.substring(dotIndex + 1);
    }
}
