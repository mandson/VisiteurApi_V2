package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Permition;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PermitionDto {
    private Long id;
    private String codePermition;
    private String description;


    public static PermitionDto fromEntity(Permition permition){
        if (permition==null){
            return null;
        }
        return PermitionDto.builder()
                .id( permition.getId() )
                .codePermition( permition.getCodePermition() )
                .description( permition.getDescription() )
                .build();
    }

    public  static Permition toEntity(PermitionDto permitionDto){
        if (permitionDto==null){
            return null;
        }
        Permition permition = new Permition();
        permition.setId( permitionDto.getId() );
        permition.setCodePermition( permitionDto.getCodePermition() );
        permition.setDescription( permitionDto.getDescription() );

        return permition;
    }
}