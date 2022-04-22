package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Departement;
import com.api.Visiteur.entities.Entreprise;
import com.api.Visiteur.entities.Role;
import com.api.Visiteur.entities.User2;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Builder
@Data
public class User2Dto {

    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @Column(length = 16)
    private Long contact;
    private String profilImage;
    private Date lastLogingDate;
    private  Date cratedAt;
    private Boolean isActive;
    private Boolean isNotLocked;
    private Role roles;
    private String nomRole;
    private Integer idRole;
    private Long identreprise;
    private Long idEntreprisef;

    private Long idDepartement;
    private Departement departement;
    private String matricule;

    public static User2Dto fromEntity(User2 user){
        if (user==null){
            return null;
        }
        return User2Dto.builder()
                .id( user.getId() )
                .userId( user.getUserId() )
                .firstName( user.getFirstName() )
                .lastName( user.getLastName() )
                .password( user.getPassword() )
                .email( user.getEmail() )
                .contact(user.getContact())
                .profilImage( user.getProfilImage() )
                .lastLogingDate( user.getLastLogingDate() )
                .cratedAt( user.getCratedAt() )
                .isActive( user.getIsActive() )
                .isNotLocked( user.getIsNotLocked() )
                .roles(user.getRoles())
                .idRole( user.getIdRole() )
                .idEntreprisef( user.getIdEntreprisef() )
                .nomRole(user.getRoles().getNameRole())
                .departement(user.getDepartement())
                .identreprise(user.getDepartement().getEntreprise().getId())
                .matricule(user.getMatricule())
                .build();
    }

    public  static User2 toEntity(User2Dto userDto){
        if (userDto==null){
            return null;
        }
        User2 user = new User2();
        user.setIdEntreprisef(userDto.getIdEntreprisef());
        user.setId( userDto.getId() );
        user.setUserId( userDto.getUserId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setPassword( userDto.getPassword() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setContact(user.getContact());
        user.setMatricule(userDto.getMatricule());
        user.setProfilImage( userDto.getProfilImage() );
        user.setLastLogingDate( userDto.getLastLogingDate() );
        user.setCratedAt( new Date() );
        user.setIsActive(userDto.getIsActive());
        user.setIsNotLocked( userDto.getIsNotLocked() );
        user.setIdRole( userDto.getIdRole() );
        user.setDepartement(
                DepartementDTO.convertDepartementDTOtoDepartement(DepartementDTO.builder().id(userDto.getIdDepartement()).build())
        );
        user.setRoles(  RoleDto.toEntity( RoleDto.builder()
                .id( userDto.getIdRole() )
                .build() ));
        return user;
    }
}
