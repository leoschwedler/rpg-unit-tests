package dev.schwedler.rpgapitests.inventario.domain;

import dev.schwedler.rpgapitests.item.domain.Item;
import dev.schwedler.rpgapitests.personagem.domain.Personagem;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @OneToOne()
    @JoinColumn(name = "id_personagem")
    private Personagem personagem;
    private Integer quantidade;
    @OneToMany(mappedBy = "inventario")
    private List<Item> itens;
}
