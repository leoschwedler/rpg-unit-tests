package dev.schwedler.rpgapitests.rpg.classe.request;

import jakarta.validation.constraints.NotBlank;

public record ClasseRequest(
        @NotBlank()
        String nome,
        String descricao) {
}