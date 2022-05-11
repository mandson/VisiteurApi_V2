package com.api.Visiteur.files.dto;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.entities.User2;
import com.api.Visiteur.files.model.UploadFile;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Builder
@Data
public class UploadFileDto {


    private Long id;
    private String fileName;
    private Date createdAt;
    public static UploadFileDto fromEntity(UploadFile uploadFile){
        if (uploadFile==null){
            return null;
        }
        return UploadFileDto.builder()
                .id( uploadFile.getId() )
                .fileName(uploadFile.getFileName())
                .createdAt(uploadFile.getCreatedAt())
                .build();
    }

}
