package dev.schwedler.rpgapitests.item.domain;

import dev.schwedler.rpgapitests.inventario.domain.Inventario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_inventario")
    private Inventario inventario;
    private String nome;
    private String tipo;
    private BigDecimal valor;
}
