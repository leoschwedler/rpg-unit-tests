package dev.schwedler.rpgapitests.classe.service;

import dev.schwedler.rpgapitests.classe.domain.Classe;
import dev.schwedler.rpgapitests.classe.mapper.ClasseMapper;
import dev.schwedler.rpgapitests.classe.repository.ClasseRepository;
import dev.schwedler.rpgapitests.classe.request.ClasseRequest;
import dev.schwedler.rpgapitests.classe.response.ClasseResponse;
import dev.schwedler.rpgapitests.exception.CustomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseService {

    private final ClasseRepository repository;
    private final ClasseMapper mapper;

    public ClasseResponse save(ClasseRequest request){
        Classe classe = repository.save(mapper.toDomain(request));
        return mapper.toResponse(classe);
    }

    public List<ClasseResponse> findAll(){
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ClasseResponse findById(@PathVariable Long id){
        Classe classe = repository.findById(id).orElseThrow(() -> new CustomNotFoundException("Classe com o id:" + id + " nao encontrada!"));
        return mapper.toResponse(classe);
    }
}
