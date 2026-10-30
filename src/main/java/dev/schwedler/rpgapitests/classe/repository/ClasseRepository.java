package dev.schwedler.rpgapitests.classe.repository;

import dev.schwedler.rpgapitests.classe.domain.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
