package br.com.ebac.memelandia_usuario.controllers;

import br.com.ebac.memelandia_usuario.entities.Usuario;
import br.com.ebac.memelandia_usuario.services.IUsuarioService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/memelandia/usuario")
public class UsuarioController {

    private final IUsuarioService service;

    @PostMapping("/novo-usuario")
    public Usuario novoUsuario(@Valid @RequestBody Usuario usuario) {
        return service.novoUsuario(usuario);
    }

    @GetMapping("/buscar-usuario-por-id/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return service.buscarUsuarioPorId(id);
    }

    @GetMapping("/listar-todos-usuarios")
    public List<Usuario> listarTodosUsuarios() {
        return service.listarTodosUsuarios();
    }

    @GetMapping("/buscar-usuario-por-email")
    public Usuario buscarUsuarioPorEmail(@Email @RequestBody String email) {
        return service.buscarUsuarioPorEmail(email);
    }
}
