package br.com.ebac.memelandia_meme.client;

import br.com.ebac.memelandia_meme.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuario", url = "${application.usuarioServiceMemelandia.endpointConsultarUsuario}")
public interface UsuarioClient {

    @RequestMapping(method = RequestMethod.GET, value = "/buscar-usuario-por-id/{id}", produces = "application/json", headers = "application/json")
    ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/listar-todos-usuarios", produces = "application/json", headers = "application/json")
    ResponseEntity<List<Usuario>> listarTodosUsuarios();

    @RequestMapping(method = RequestMethod.GET, value = "/buscar-usuario-por-email", produces = "application/json", headers = "application/json")
    ResponseEntity<Usuario> buscarUsuarioPorEmail(@Valid @RequestBody String email);
}
