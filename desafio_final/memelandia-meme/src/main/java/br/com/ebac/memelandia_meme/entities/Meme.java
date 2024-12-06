package br.com.ebac.memelandia_meme.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome do meme é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "A descrição do meme é obrigatório")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @NotBlank(message = "A url do meme é obrigatório")
    @Column(name = "url_link", nullable = false)
    private String urlLink;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "categoria_meme_id")
    private CategoriaMeme categoriaMeme;

    @JoinColumn(name = "usuario_id")
    private Long usuarioId;
}
