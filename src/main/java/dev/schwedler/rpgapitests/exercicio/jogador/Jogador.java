package dev.schwedler.rpgapitests.exercicio.jogador;

import jakarta.persistence.*;

@Entity
public class Jogador {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    /*
     * ONE TO ONE (1 para 1) - Jogador <-> Personagem  |  LADO DONO
     *
     * Significado: 1 jogador tem exatamente 1 personagem, e 1 personagem pertence a 1 jogador.
     *
     * Como funciona no banco:
     *   - A tabela "jogador" ganha a coluna "id_personagem" (chave estrangeira / FK).
     *   - O OneToOne cria uma restrição UNIQUE nessa coluna: dois jogadores
     *     NÃO podem apontar para o mesmo personagem.
     *
     * Regras:
     *   - Quem tem o @JoinColumn é o LADO DONO: é a tabela que guarda a FK.
     *   - O outro lado (Personagem.jogador) usa "mappedBy" e NÃO cria coluna nova.
     *   - Para gravar o vínculo, preencha SEMPRE pelo lado dono:
     *         jogador.setPersonagem(personagem);   // grava a FK
     *     Só fazer personagem.setJogador(jogador) NÃO grava nada no banco.
     *
     * @JoinColumn(name = "id_personagem") -> nome da coluna FK criada em "jogador".
     */
    @OneToOne
    @JoinColumn(name = "id_personagem")
    private Personagem personagem;
}
