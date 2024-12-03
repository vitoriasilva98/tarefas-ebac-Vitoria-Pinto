package br.com.ebac.memelandia_usuario.controllers;

import br.com.ebac.memelandia_usuario.entities.Usuario;
import br.com.ebac.memelandia_usuario.models.UsuarioEmailDTO;
import br.com.ebac.memelandia_usuario.services.IUsuarioService;
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

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return service.buscarUsuario(id);
    }

    @GetMapping("/listar-todos-usuarios")
    public List<Usuario> listarTodosUsuarios() {
        return service.listarTodosUsuarios();
    }

    @PostMapping("/buscar-usuario-por-email")
    public Usuario buscarUsuarioPorEmail(@Valid @RequestBody UsuarioEmailDTO dto) {
        return service.buscarUsuarioPorEmail(dto.getEmail());
    }
}
