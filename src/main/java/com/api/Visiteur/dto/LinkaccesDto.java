package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Linkacces;
import com.api.Visiteur.entities.Permition;
import com.api.Visiteur.entities.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LinkaccesDto {
    private Long id;
    private Role roles;
    private Integer idRole;
    private Long idPermition;
    private Permition permitions;
    private String userCrateName;

    public static LinkaccesDto fromEntity(Linkacces linkacces){
        if (linkacces==null){
            return null;
        }
        return LinkaccesDto.builder()
                .id( linkacces.getId() )
                .userCrateName( linkacces.getUserCrateName() )
                .permitions( linkacces.getPermitions() )
                .roles( linkacces.getRoles() )
                .idRole( linkacces.getIdRole() )
                .idPermition( linkacces.getIdPermition() )
                .build();
    }

    public  static Linkacces toEntity(LinkaccesDto linkaccesDto){
        if (linkaccesDto==null){
            return null;
        }
        Linkacces linkacces = new Linkacces();
        linkacces.setIdPermition( linkaccesDto.getIdPermition() );
        linkacces.setIdRole( linkaccesDto.getIdRole() );
        linkacces.setId( linkaccesDto.getId() );
        linkacces.setUserCrateName( linkaccesDto.getUserCrateName() );
        linkacces.setPermitions(PermitionDto.toEntity( PermitionDto.builder()
                .id( linkaccesDto.getIdPermition() )
                .build() ) );

        linkacces.setRoles( RoleDto.toEntity( RoleDto.builder()
                .id( linkaccesDto.getIdRole() )
                .build() ) );

        return linkacces;
    }
}
