package dev.schwedler.rpgapitests.exercicio.jogador;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Double peso;

    /*
     * MANY TO MANY (N para N) - Item <-> Personagem  |  LADO DONO
     *
     * Significado: 1 item pode estar com vários personagens, e 1 personagem
     * pode ter vários itens.
     *
     * Como funciona no banco:
     *   - N para N nunca cabe em uma coluna só, então é criada uma 3ª tabela
     *     (tabela intermediária / de junção) chamada "item_personagem".
     *   - Ela tem só 2 colunas (as FKs): "id_item" e "id_personagem".
     *     Cada linha = um vínculo entre um item e um personagem.
     *   - NÃO precisa criar entidade para essa tabela: o Hibernate cria sozinho
     *     a partir do @JoinTable. (Só criaria entidade se a relação tivesse
     *     dados próprios, como "quantidade".)
     *
     * Anotação @JoinTable (só no LADO DONO):
     *   - name              -> nome da tabela intermediária.
     *   - joinColumns       -> coluna FK que aponta para ESTA entidade (Item).
     *   - inverseJoinColumns-> coluna FK que aponta para a OUTRA entidade (Personagem).
     *
     * Regras:
     *   - Só o lado dono grava na tabela intermediária. Para vincular:
     *         item.getPersonagems().add(personagem);   // grava
     *     Fazer personagem.getItems().add(item) NÃO grava nada.
     *   - O outro lado (Personagem.items) usa mappedBy = "personagems",
     *     que é o NOME DESTE CAMPO.
     *   - Escolher o dono: normalmente é quem "possui" o outro no domínio
     *     (personagem tem itens), ou o lado pelo qual você faz os vínculos na API.
     *
     * A lista é inicializada com new ArrayList<>() para evitar NullPointerException no add.
     */
    @ManyToMany
    @JoinTable(
            name = "item_personagem",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_personagem")
    )
    private List<Personagem> personagems = new ArrayList<>();
}
