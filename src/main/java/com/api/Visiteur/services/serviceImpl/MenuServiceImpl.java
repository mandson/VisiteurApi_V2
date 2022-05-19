package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.repository.MenuRepository;
import com.api.Visiteur.services.MenueService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class MenuServiceImpl implements MenueService {

    @Autowired
    MenuRepository menuRepository;


    @Override
    public List<MenuDTO> listMenuByAccess(String access) {
        return menuRepository.findAll().stream()
                .filter(menu ->access.equals(access))

                .map(MenuDTO::fromEntity)
                .collect(Collectors.toList())

                ;    }

    @Override
    public String exportReport(String format) throws FileNotFoundException, JRException {
        List<MenuDTO> menuList = menuRepository.findAll().stream()
                .map(MenuDTO::fromEntity)
                .collect(Collectors.toList());

        String path= "C:/Users/USER/Pictures/uploaded/";
        File file = ResourceUtils.getFile("classpath:menues.jrxml");
        JasperReport jasper= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(menuList);
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("gain java","Knowlege");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
        if (format.equalsIgnoreCase("html"))
        {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"menues.html");
        }

        if (format.equalsIgnoreCase("pdf"))
        {
            JasperExportManager.exportReportToPdfFile(jasperPrint,  path+"menues.pdf");

        }




        return "path:"+path;
    }
}
