package dev.schwedler.rpgapitests.user.service;

import dev.schwedler.rpgapitests.exception.CustomExceptionEmailDuplicated;
import dev.schwedler.rpgapitests.exception.CustomExceptionNotFoundException;
import dev.schwedler.rpgapitests.user.domain.User;
import dev.schwedler.rpgapitests.user.mapper.UserMapper;
import dev.schwedler.rpgapitests.user.repository.UserRepository;
import dev.schwedler.rpgapitests.user.request.UserRequest;
import dev.schwedler.rpgapitests.user.response.UserResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    //CREATE
    @Transactional
    public UserResponse create(UserRequest request){

        if(repository.existsByEmail(request.email())){
            throw new CustomExceptionEmailDuplicated("Email Duplicated");
        }
        User user = repository.save(mapper.toDomain(request));
        return mapper.toResponse(user);
    }

    //READ
    @Transactional(readOnly = true)
    public List<UserResponse> findAll(){
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public UserResponse findById(Long id){
        User user = repository.findById(id).orElseThrow(() -> new CustomExceptionNotFoundException("User not found ID: " + id));
        return mapper.toResponse(user);
    }

    //UPDATE
    @Transactional
    public UserResponse update(Long id, UserRequest request){

        User user = repository.findById(id).orElseThrow(() -> new CustomExceptionNotFoundException("User not found ID: " + id));
        if(repository.existsByEmailAndIdNot(request.email(), id)){
            throw new CustomExceptionEmailDuplicated("Email Duplicated");
        }
        mapper.updateDomain(request,user);
        return mapper.toResponse(user);
    }

    //DELETE
    @Transactional
    public void delete(Long id){
        User user = repository.findById(id).orElseThrow(() -> new CustomExceptionNotFoundException("User not found ID: " + id));
        repository.delete(user);
    }
}
