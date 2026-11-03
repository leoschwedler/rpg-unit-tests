package dev.schwedler.rpgapitests.user.controller;

import dev.schwedler.rpgapitests.exception.CustomExceptionEmailDuplicated;
import dev.schwedler.rpgapitests.exception.CustomExceptionNotFoundException;
import dev.schwedler.rpgapitests.user.domain.User;
import dev.schwedler.rpgapitests.user.request.UserRequest;
import dev.schwedler.rpgapitests.user.response.UserResponse;
import dev.schwedler.rpgapitests.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request){
      return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    //READ
    @GetMapping
    public ResponseEntity<List<UserResponse> > findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
     return ResponseEntity.ok(service.findById(id));
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.update(id,request));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
      return  ResponseEntity.noContent().build();
    }
}
