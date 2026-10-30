package dev.schwedler.rpgapitests.classe.controller;

import dev.schwedler.rpgapitests.classe.domain.Classe;
import dev.schwedler.rpgapitests.classe.request.ClasseRequest;
import dev.schwedler.rpgapitests.classe.response.ClasseResponse;
import dev.schwedler.rpgapitests.classe.service.ClasseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/classe")
@RequiredArgsConstructor
public class ClasseControll {

    private final ClasseService service;


    @PostMapping
    public ResponseEntity<ClasseResponse> save(@Valid @RequestBody ClasseRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<ClasseResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClasseResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


}
