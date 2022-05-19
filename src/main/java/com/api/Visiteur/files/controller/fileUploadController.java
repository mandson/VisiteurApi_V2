package com.api.Visiteur.files.controller;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.files.model.UploadFile;
import com.api.Visiteur.files.repository.FileUploadRepossitory;
import com.api.Visiteur.files.service.FileUploadService;
import com.api.Visiteur.services.RoleService;
import com.api.Visiteur.web.controller.VisiteCategorieController;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.api.Visiteur.utils.constants.APP_ROOT;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("api")

public class fileUploadController {
    @Autowired
    RoleService roleService;


    @Autowired
    private FileUploadService fileUploadService;


    @Autowired
    private FileUploadRepossitory fileUploadRepossitory;


    @PostMapping("/upload/local")
    public void upload(@RequestParam("file")MultipartFile multipartFile){
            fileUploadService.uploadToLocal(multipartFile);
    }




    @PostMapping("/upload/db")
    public void uploadDb(@RequestParam("file")MultipartFile multipartFile){
            fileUploadService.uploadToDb(multipartFile);
            fileUploadService.uploadToLocal(multipartFile);

    }


    //Methode de lecture des images
    @GetMapping(path="/download/local/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] images(@PathVariable(name ="id") Long id) throws Exception{
        UploadFile f = fileUploadRepossitory.findById(id).get();
        String photoName = f.getFileName();
        //chemin d'acces externe des images

        File file = new File(System.getProperty("user.home")+"/Pictures/uploaded/"+photoName);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    //Methode de lecture des images
    @GetMapping(path="/download/filename/{filename}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] images(@PathVariable(name ="filename") String filename) throws Exception{
        UploadFile fs = fileUploadRepossitory.findByFileName(filename);
        String photoName = fs.getFileName();
        //chemin d'acces externe des images
        File file = new File(System.getProperty("user.home")+"/Pictures/uploaded/"+photoName);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }




    @RequestMapping("/pdf")

    public void getReportsinPDF(HttpServletResponse response) throws JRException, IOException {

        //Compiled report
        InputStream jasperStream = (InputStream) this.getClass().getResourceAsStream("/VisiteurList.jasper");

        //Adding attribute names
        Map params = new HashMap();
        params.put("id","id");
        params.put("nameRole","nameRole");
        params.put("codeRole","codeRole");
        params.put("descriptionRole","descriptionRole");
        params.put("userCrateName","userCrateName");

        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(roleService.listRole());

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, source);

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=StudentList.pdf");

        final ServletOutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }
}
