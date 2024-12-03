package br.com.ebac.memelandia_usuario.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEmailDTO {

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email do usuário é obrigatório")
    private String email;
}
