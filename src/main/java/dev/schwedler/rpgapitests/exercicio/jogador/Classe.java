package dev.schwedler.rpgapitests.exercicio.jogador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Classe {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    /*
     * ONE TO ONE (1 para 1) - Classe <-> Personagem  |  LADO INVERSO
     *
     * Significado: 1 classe está ligada a 1 personagem.
     *
     * Como funciona no banco:
     *   - A tabela "classe" NÃO ganha nenhuma coluna por causa deste campo.
     *   - A FK fica na tabela "personagem" (coluna "id_classe"), porque
     *     o lado dono é Personagem.classe.
     *
     * Regras do lado inverso:
     *   - Usa "mappedBy" em vez de @JoinColumn.
     *   - mappedBy = NOME DO CAMPO no lado dono (Personagem.classe) e não o
     *     nome da classe nem da coluna. Se renomear o campo lá, mude aqui também,
     *     senão a aplicação nem sobe.
     *   - Serve para NAVEGAR (classe.getPersonagem()), mas não grava o vínculo.
     *     Para gravar: personagem.setClasse(classe).
     *
     * Observação de estudo: OneToOne cria UNIQUE em "id_classe", então só 1 personagem
     * pode ter cada classe. Em um RPG real o correto seria ManyToOne (várias
     * personagens com a mesma classe).
     */
    @OneToOne(mappedBy = "classe")
    private Personagem personagem;
}
