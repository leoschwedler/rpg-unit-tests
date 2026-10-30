package dev.schwedler.rpgapitests.rpg.classe.domain;

import dev.schwedler.rpgapitests.rpg.personagem.domain.Personagem;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "classe")
    private List<Personagem> personagems;
}
