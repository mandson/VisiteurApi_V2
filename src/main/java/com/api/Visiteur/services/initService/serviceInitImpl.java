package com.api.Visiteur.services.initService;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.RoleDto;
import com.api.Visiteur.entities.*;
import com.api.Visiteur.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
@Transactional
public class serviceInitImpl implements serviceInit {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public void initMenu() {

        Menu menu3 = new Menu();
        menu3.setTitre("Visiteurs");
        menu3.setLink("visiteurliste");
        menu3.setIcon("walk-outline");
        menu3.setAccess("ADMIN");
        menuRepository.save(menu3);

        Menu menu1 = new Menu();
        menu1.setTitre("Personnels");
        menu1.setLink("personnel-liste");
        menu1.setIcon("people-outline");
        menu1.setAccess("ADMIN");
        menuRepository.save(menu1);


        Menu menu4 = new Menu();
        menu4.setTitre("Mes Visites");
        menu4.setIcon("accessibility-outline");
        menu4.setLink("mes-visites");
        menu4.setAccess("USER");
        menuRepository.save(menu4);

        Menu menu5 = new Menu();
        menu5.setTitre("Mon Compte");
        menu5.setIcon("person-outline");
        menu5.setLink("user-profil");
        menu5.setAccess("USER");
        menuRepository.save(menu5);


        Menu menu2 = new Menu();
        menu2.setTitre("Infos Entreprise");
        menu2.setLink("administration");
        menu2.setIcon("business-outline");
        menu2.setAccess("ADMIN");
        menuRepository.save(menu2);


        Menu menu6 = new Menu();
        menu6.setTitre("Access & Security");
        menu6.setIcon("lock-closed-outline");
        menu6.setLink("acces-security");
        menu6.setAccess("ADMIN");
        menuRepository.save(menu6);

    }

    @Override
    public void initEntreprise() {
        Entreprise entreprise = new Entreprise();
        entreprise.setNomEntreprise("IPSUM ENTREPRISE");
        entreprise.setSigle("MCT");
        entreprise.setBoitePostal("mcpBP01Ouaga");
        entreprise.setLogo("logo non definie");
        entreprise.setIfu("0001fu");
        entreprise.getCratedAt();
        entreprise.setPays("CI");
        entreprise.setVille("Ouaguadougou");

        entrepriseRepository.save(entreprise);
/*
        Entreprise entreprise2 = new Entreprise();
        entreprise2.setNomEntreprise("ADV-Technologies SA");
        entreprise2.setSigle("ADV-SA");
        entreprise2.setBoitePostal("mcpBP01BOBO");
        entreprise2.setLogo("logo undefine");
        entrepriseRepository.save(entreprise2);*/
    }


    @Override
    public void initRole() {
        Role role1= new Role();
        Role role2= new Role();
        Role role3= new Role();
        role1.setId(1);
        role1.setNameRole("ADMIN");
        role1.setDescriptionRole("Administrateur principale du compte de la societe");
        role1.setCodeRole("R-001");
        role1.setUserCrateName("ADV-TECHNOLOGIES-SA");
        roleRepository.save(role1);

        role2.setId(2);
        role2.setNameRole("USER");
        role2.setDescriptionRole("Pour les simples utilisateurs de la societe employer etc..");
        role2.setCodeRole("R-002");
        role2.setUserCrateName("ADV-TECHNOLOGIES-SA");
        roleRepository.save(role2);

        role3.setId(3);
        role3.setNameRole("SUPER-USER");
        role3.setDescriptionRole("DROIT RESERVER UNIQUEMENT A L ADMINISTRATEUR PRINCIPALE DE LA PLATEFORME..");
        role3.setCodeRole("R-003");
        role3.setUserCrateName("ADV-TECHNOLOGIES-SA");
        roleRepository.save(role3);

    }

    @Override
    public void initDepartement() {
        Departement departement= new Departement();
        departement.setEntreprise(EntrepriseDTO.convertEntrepriseDTOtoEntreprise(EntrepriseDTO.builder().id(1L).build()));
        departement.setNomDepartement(" General");
        departement.setIdEntreprisef(1L);
        departement.setDescriptionDepartement("Depatement par defaut");
        departementRepository.save(departement);

     /*   Departement departement2= new Departement();
        departement2.setEntreprise(EntrepriseDTO.convertEntrepriseDTOtoEntreprise(EntrepriseDTO.builder().id(2L).build()));
        departement2.setNomDepartement("Defaul Departement");
        departementRepository.save(departement2);*/
    }


    @Override
    public void initUser() {
        User2 user=new User2();
        user.setFirstName("MANDE");
        user.setLastName("Hamed");
        user.setIdRole(7);
        user.setEmail("admin@gmail.com");
        user.setPassword("password123");
        user.setIdDepartement(1L);
        user.setBureau("B001");
        user.setUserId("1");
        user.setIdEntreprisef(1L);
        user.setDepartement(
        DepartementDTO.convertDepartementDTOtoDepartement(DepartementDTO.builder().id(1L).build())
        );
        user.setRoles(
                RoleDto.toEntity(RoleDto.builder().id(7).build())
        );
        user.setIsActive(true);
        user.setIsNotLocked(true);
        user.setProfilImage("img.png");
        userRepository.save(user);




    }


}
