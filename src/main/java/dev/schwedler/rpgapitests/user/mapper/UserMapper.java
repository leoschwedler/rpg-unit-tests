package dev.schwedler.rpgapitests.user.mapper;

import dev.schwedler.rpgapitests.user.domain.User;
import dev.schwedler.rpgapitests.user.request.UserRequest;
import dev.schwedler.rpgapitests.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserRequest request);

    UserResponse toResponse(User domain);

    void updateDomain(UserRequest request, @MappingTarget User domain);

}
