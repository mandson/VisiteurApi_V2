package com.api.Visiteur.files.service.other;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.files.dto.UploadFileDto;
import com.api.Visiteur.files.repository.FileUploadRepossitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ImageServeImpl implements ImageServe {

   @Autowired
    FileUploadRepossitory fileUploadRepossitory;
    @Override
    public List<UploadFileDto> listFile() {
        return fileUploadRepossitory.findAll().stream()
                .map( UploadFileDto::fromEntity)
                .collect( Collectors.toList())
                ;
    }
}
