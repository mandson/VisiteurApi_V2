package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.repository.LinkaccesRepository;
import com.api.Visiteur.repository.MenuRepository;
import com.api.Visiteur.services.MenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
}
