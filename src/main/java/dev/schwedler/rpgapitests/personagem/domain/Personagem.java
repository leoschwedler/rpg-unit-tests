package dev.schwedler.rpgapitests.personagem.domain;

import dev.schwedler.rpgapitests.classe.domain.Classe;
import dev.schwedler.rpgapitests.inventario.domain.Inventario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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
