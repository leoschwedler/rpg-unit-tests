package dev.schwedler.rpgapitests.exercicio.jogador;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habilidade {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private BigDecimal custoMana;

    /*
     * MANY TO MANY (N para N) - Habilidade <-> Personagem  |  LADO INVERSO
     *
     * Significado: 1 habilidade pode ser usada por vários personagens, e
     * 1 personagem pode ter várias habilidades.
     *
     * Como funciona no banco:
     *   - A tabela "habilidade" NÃO ganha coluna nenhuma por causa deste campo.
     *   - O vínculo fica na tabela intermediária "personagem_habilidade",
     *     definida no lado dono (Personagem.habilidades).
     *
     * Regras do lado inverso:
     *   - Usa @ManyToMany(mappedBy = "...") e NÃO tem @JoinTable.
     *     (@JoinTable nos dois lados criaria 2 tabelas intermediárias desencontradas.)
     *   - mappedBy = NOME DO CAMPO no lado dono (Personagem.habilidades).
     *   - Este lado serve para NAVEGAR (habilidade.getPersonagens()). Adicionar
     *     aqui NÃO grava o vínculo. Para gravar:
     *         personagem.getHabilidades().add(habilidade);
     *
     * A lista é inicializada com new ArrayList<>() para evitar NullPointerException no add.
     */
    @ManyToMany(mappedBy = "habilidades")
    private List<Personagem> personagens = new ArrayList<>();
}
