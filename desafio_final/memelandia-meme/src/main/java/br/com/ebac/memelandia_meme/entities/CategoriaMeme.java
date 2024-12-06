package br.com.ebac.memelandia_meme.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CategoriaMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome da categoria do meme é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "A descrição da categoria do meme é obrigatório")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @NotNull(message = "O id do usuário é obrigatório")
    @JoinColumn(name = "usuario_id")
    private Long usuarioId;
}
