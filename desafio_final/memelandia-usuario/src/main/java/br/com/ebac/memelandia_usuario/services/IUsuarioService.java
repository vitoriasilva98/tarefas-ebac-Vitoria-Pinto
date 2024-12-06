package br.com.ebac.memelandia_usuario.services;

import br.com.ebac.memelandia_usuario.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario novoUsuario(Usuario usuario);
    List<Usuario> listarTodosUsuarios();
    Usuario buscarUsuarioPorId(Long id);
    Usuario buscarUsuarioPorEmail(String email);
}
