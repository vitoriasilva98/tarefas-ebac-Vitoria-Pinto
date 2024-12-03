package br.com.ebac.memelandia_usuario.services.impl;

import br.com.ebac.memelandia_usuario.entities.Usuario;
import br.com.ebac.memelandia_usuario.exceptions.UsuarioException;
import br.com.ebac.memelandia_usuario.repositories.IUsuarioRepository;
import br.com.ebac.memelandia_usuario.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        try {
            if(usuario == null) {
                throw new UsuarioException("Usuário não pode ser nulo");
            }

            Usuario usuarioPesquisado = buscarUsuarioPorEmail(usuario.getEmail());

            if(usuarioPesquisado != null) {
                if(usuarioPesquisado.getEmail().equals(usuario.getEmail())) {
                    throw new UsuarioException("O email informado já existe na base de dados, por favor escolha outro");
                }
            }

            usuario.setDataCadastro(new Date());

            return repository.save(usuario);
        } catch (Exception ex) {
            log.error("[MEMELANDIA][USUARIO][NOVO_USUARIO] Erro ao criar novo usuario: {}", ex.getMessage());
            throw new UsuarioException(ex);
        }
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            log.error("[MEMELANDIA][USUARIO][LISTAR_TODOS_USUARIOS] Erro ao listar todos os usuarios: {}", ex.getMessage());
            throw new UsuarioException(ex);
        }
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        try {
            if(id == null) {
                throw new UsuarioException("O id do usuário para pesquisa não pode ser nulo.");
            }
            Optional<Usuario> usuarioPesquisado = repository.findById(id);

            return usuarioPesquisado.orElse(null);
        } catch (Exception ex) {
            log.error("[MEMELANDIA][USUARIO][BUSCAR_USUARIO] Erro ao buscar usuario: {}", ex.getMessage());
            throw new UsuarioException(ex);
        }
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        try {
            if(email == null || email.isBlank()) {
                throw new UsuarioException("O id do usuário para pesquisa não pode ser nulo.");
            }
            Optional<Usuario> usuarioPesquisado = repository.findByEmail(email);

            return usuarioPesquisado.orElse(null);
        } catch (Exception ex) {
            log.error("[MEMELANDIA][USUARIO][BUSCAR_USUARIO_POR_EMAIL] Erro ao buscar usuario: {}", ex.getMessage());
            throw new UsuarioException(ex);
        }
    }
}
