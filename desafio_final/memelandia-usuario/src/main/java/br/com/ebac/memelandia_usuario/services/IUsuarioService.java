package br.com.ebac.memelandia_usuario.services;

import br.com.ebac.memelandia_usuario.entities.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {

    ResponseEntity<Usuario> novoUsuario(Usuario usuario);
    ResponseEntity<List<Usuario>> listarTodosUsuarios();
    ResponseEntity<Usuario> buscarUsuarioPorId(Long id);
    ResponseEntity<Usuario> buscarUsuarioPorEmail(String email);
}
