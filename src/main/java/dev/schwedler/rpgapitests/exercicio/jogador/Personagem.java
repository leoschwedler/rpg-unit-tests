package dev.schwedler.rpgapitests.exercicio.jogador;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Integer nivel;

    /*
     * ONE TO ONE - Personagem <-> Jogador  |  LADO INVERSO
     *
     * A FK ("id_personagem") fica na tabela "jogador" (Jogador.personagem é o dono).
     * Aqui NÃO cria coluna. mappedBy = "personagem" é o NOME DO CAMPO em Jogador.
     * Serve para navegar (personagem.getJogador()). Para gravar o vínculo use
     * jogador.setPersonagem(personagem).
     */
    @OneToOne(mappedBy = "personagem")
    private Jogador jogador;

    /*
     * ONE TO ONE - Personagem <-> Classe  |  LADO DONO
     *
     * A tabela "personagem" ganha a coluna FK "id_classe" (com UNIQUE, por ser OneToOne).
     * Para gravar o vínculo: personagem.setClasse(classe).
     * O outro lado (Classe.personagem) usa mappedBy = "classe" (nome deste campo).
     */
    @OneToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;

    /*
     * MANY TO MANY - Personagem <-> Habilidade  |  LADO DONO
     *
     * 1 personagem tem várias habilidades; 1 habilidade é usada por vários personagens.
     *
     * No banco é criada a tabela intermediária "personagem_habilidade" com 2 FKs.
     * Não precisa de entidade para ela: o @JoinTable faz o Hibernate criar.
     *
     * @JoinTable (SÓ no lado dono):
     *   - name               -> nome da tabela intermediária.
     *   - joinColumns        -> FK que aponta para ESTA entidade (Personagem).
     *   - inverseJoinColumns -> FK que aponta para a OUTRA entidade (Habilidade).
     *
     * Para gravar o vínculo: personagem.getHabilidades().add(habilidade).
     * O outro lado (Habilidade.personagens) usa mappedBy = "habilidades" (nome deste campo).
     */
    @ManyToMany
    @JoinTable(
            name = "personagem_habilidade",  // tabela intermediária
            joinColumns = @JoinColumn(name = "id_personagem"), // FK que aponta para ESTA entidade
            inverseJoinColumns = @JoinColumn(name = "id_habilidade") // FK que aponta para a OUTRA
    )
    private List<Habilidade> habilidades = new ArrayList<>();

    /*
     * MANY TO MANY - Personagem <-> Item  |  LADO INVERSO
     *
     * O dono é Item.personagems (que tem o @JoinTable "item_personagem").
     * Aqui NÃO tem @JoinTable e NÃO cria coluna nem tabela.
     * mappedBy = "personagems" é o NOME DO CAMPO em Item.
     *
     * ATENÇÃO: adicionar aqui (personagem.getItems().add(item)) NÃO grava o vínculo.
     * Só serve para ler/navegar. Para gravar: item.getPersonagems().add(personagem).
     */
    @ManyToMany(mappedBy = "personagems")
    private List<Item> items = new ArrayList<>();
}
