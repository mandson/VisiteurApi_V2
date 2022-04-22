package com.api.Visiteur.services.initService;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface serviceInit {
    public  void initMenu();
    public  void initEntreprise();
    public  void initRole();
    public void initDepartement();
    public  void initUser();

}
