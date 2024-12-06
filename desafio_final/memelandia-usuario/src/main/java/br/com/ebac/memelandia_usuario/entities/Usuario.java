package br.com.ebac.memelandia_usuario.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_usuario")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email do usuário é obrigatório")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;
}
