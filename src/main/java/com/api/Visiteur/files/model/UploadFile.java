package com.api.Visiteur.files.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UploadFile {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private String fileuserId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Lob
    private byte[] fileData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFileuserId() {
        return fileuserId;
    }

    public void setFileuserId(String fileuserId) {
        this.fileuserId = fileuserId;
    }
}
