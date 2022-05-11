package com.api.Visiteur.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class FileUploadResponse {
    private String name;
    private String contentType;
    private String url;
}
