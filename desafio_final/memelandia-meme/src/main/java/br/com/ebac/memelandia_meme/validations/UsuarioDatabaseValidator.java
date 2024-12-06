package br.com.ebac.memelandia_meme.validations;

import br.com.ebac.memelandia_meme.client.UsuarioClient;
import br.com.ebac.memelandia_meme.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UsuarioDatabaseValidator {

    private final UsuarioClient usuarioClient;

    public void verifiqueSeUsuarioExiste(Long usuarioId) {
        Usuario usuarioEncontrado = usuarioClient.buscarUsuarioPorId(usuarioId);

        if(usuarioEncontrado == null) {
            throw new NoSuchElementException("Nenhum usuário foi encontrado na base de dados com esse id.");
        }
    }
}
