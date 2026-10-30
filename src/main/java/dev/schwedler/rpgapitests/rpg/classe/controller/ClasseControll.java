package dev.schwedler.rpgapitests.rpg.classe.controller;

import dev.schwedler.rpgapitests.rpg.classe.request.ClasseRequest;
import dev.schwedler.rpgapitests.rpg.classe.response.ClasseResponse;
import dev.schwedler.rpgapitests.rpg.classe.service.ClasseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/classes")
@RequiredArgsConstructor
public class ClasseControll {

    private final ClasseService service;


    @PostMapping
    public ResponseEntity<ClasseResponse> save(@Valid @RequestBody ClasseRequest request){
        ClasseResponse response = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ClasseResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClasseResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClasseResponse> update(@PathVariable Long id,@Valid @RequestBody ClasseRequest request){
       return ResponseEntity.ok(service.update(id,request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
