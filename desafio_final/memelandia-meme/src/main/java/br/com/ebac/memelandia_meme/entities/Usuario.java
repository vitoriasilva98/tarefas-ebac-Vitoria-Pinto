package br.com.ebac.memelandia_meme.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private Date dataCadastro;
}
