package dev.schwedler.rpgapitests.classe.mapper;

import dev.schwedler.rpgapitests.classe.domain.Classe;
import dev.schwedler.rpgapitests.classe.request.ClasseRequest;
import dev.schwedler.rpgapitests.classe.response.ClasseResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClasseMapper {

    Classe toDomain(ClasseRequest request);

    ClasseResponse toResponse(Classe classe);

}

