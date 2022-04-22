package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Menu;
import com.api.Visiteur.entities.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class MenuDTO {

    private Integer id;
    private String titre;
    private String  icon;
    private String link;
    private String  access;
    public static MenuDTO fromEntity(Menu menu){
        if (menu==null){
            return null;
        }
        return MenuDTO.builder()
                .id( menu.getId() )
                .titre(menu.getTitre())
                .link(menu.getLink())
                .icon(menu.getIcon())
                .access(menu.getAccess())
                .build();
    }

    public  static Menu toEntity(MenuDTO menuDTO){
        if (menuDTO==null){
            return null;
        }
        Menu menu = new Menu();
        menu.setId( menuDTO.getId() );
        menu.setTitre(menuDTO.getTitre());
        menu.setAccess(menuDTO.getAccess());
        menu.setIcon(menuDTO.getIcon());
        menu.setLink(menuDTO.getLink());
       // role.setPermitions( roleDto.getPermitions() );
        return menu;
    }

}
