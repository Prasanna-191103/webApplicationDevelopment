package com.intern.datastore;


import com.intern.datastore.dao.FileuploadDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
public class fileUploadView extends HttpServlet implements Serializable{

    private String file_Name;
    private int file_id;
    private Blob filedata;
    private int user_id;
    private String file_format;
    private UploadedFile fileUp;

    public UploadedFile getFileUp() {
        return fileUp;
    }

    public void setFileUp(UploadedFile fileUp) {
        this.fileUp = fileUp;
    }
    
    public Blob getFiledata() {
        return filedata;
    }

    public void setFiledata(Blob filedata) {
        this.filedata = filedata;
    }

    public String getFile_Name() {
        return file_Name;
    }

    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFile_format() {
        return file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public void upload() throws IOException, SQLException{
        
        boolean validu = FileuploadDAO.saveFile(user_id,fileUp, file_format);
        if (validu) {
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("File Uploaded successfully"));
        }
        else {
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error in File Uploaded")); 
        }
        PrimeFaces.current().ajax().update("myForm:messages");
    }
}

















//    public void uploadMultiple() {
//        if (files != null) {
//            for (UploadedFile f : files.getFiles()) {
//                FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            }
//        }
//    }
//
//    public void handleFileUpload(FileUploadEvent event) {
//        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//
//    public void handleFileUploadTextarea(FileUploadEvent event) {
//        String jsVal = "PF('textarea').jq.val";
//        String fileName = EscapeUtils.forJavaScript(event.getFile().getFileName());
//        PrimeFaces.current().executeScript(jsVal + "(" + jsVal + "() + '\\n\\n" + fileName + " uploaded.')");
//    }
//
//    public void handleFilesUpload(FilesUploadEvent event) {
//        for (UploadedFile f : event.getFiles().getFiles()) {
//            FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
//    }
//
//    public UploadedFile getFile() {
//        return file;
//    }
//
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }
//
//    public UploadedFiles getFiles() {
//        return files;
//    }
//
//    public void setFiles(UploadedFiles files) {
//        this.files = files;
//    }
//
//    public String getDropZoneText() {
//        return dropZoneText;
//    }
//
//    public void setDropZoneText(String dropZoneText) {
//        this.dropZoneText = dropZoneText;
//    }

