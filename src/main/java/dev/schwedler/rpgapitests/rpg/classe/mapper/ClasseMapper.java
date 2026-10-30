package dev.schwedler.rpgapitests.rpg.classe.mapper;

import dev.schwedler.rpgapitests.rpg.classe.domain.Classe;
import dev.schwedler.rpgapitests.rpg.classe.request.ClasseRequest;
import dev.schwedler.rpgapitests.rpg.classe.response.ClasseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ClasseMapper {

    Classe toDomain(ClasseRequest request);

    ClasseResponse toResponse(Classe domain);

    void updateDomain(ClasseRequest request, @MappingTarget Classe domain);

}

