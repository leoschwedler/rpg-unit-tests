package dev.schwedler.rpgapitests.rpg.personagem.domain;

import dev.schwedler.rpgapitests.rpg.classe.domain.Classe;
import dev.schwedler.rpgapitests.rpg.inventario.domain.Inventario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;
    private String nome;
    private Integer nivel;
    @OneToOne(mappedBy = "personagem" )
    private Inventario inventario;
}
