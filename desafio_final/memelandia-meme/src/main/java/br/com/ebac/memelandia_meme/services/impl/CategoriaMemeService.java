package br.com.ebac.memelandia_meme.services.impl;

import br.com.ebac.memelandia_meme.client.UsuarioClient;
import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import br.com.ebac.memelandia_meme.entities.Usuario;
import br.com.ebac.memelandia_meme.exceptions.MemeException;
import br.com.ebac.memelandia_meme.repositories.ICategoriaMemeRepository;
import br.com.ebac.memelandia_meme.services.ICategoriaMemeService;
import br.com.ebac.memelandia_meme.validations.UsuarioDatabaseValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaMemeService implements ICategoriaMemeService {

    private final ICategoriaMemeRepository repository;
    private final UsuarioDatabaseValidator usuarioDatabaseValidator;

    @Override
    public ResponseEntity<CategoriaMeme> novaCategoriaMeme(CategoriaMeme categoria) {
        try {
            validarObjetoCategoriaMeme(categoria);
            usuarioDatabaseValidator.verifiqueSeUsuarioExiste(categoria.getUsuarioId());

            categoria.setDataCadastro(new Date());

            return ResponseEntity.ok(repository.save(categoria));
        }catch (Exception ex) {
            log.error("[MEMELANDIA][CATEGORIA_MEME][NOVA_CATEGORIA_MEME] Erro ao criar nova categoria de meme: {}", ex.getMessage());
            throw new MemeException();
        }
    }

    @Override
    public ResponseEntity<CategoriaMeme> buscarCategoriaMemePorId(Long id) {
        try {

            if(id == null) {
                throw new MemeException("O id não pode ser nulo");
            }

            CategoriaMeme catgoriaEncontrada = repository.findCategoriaMemeById(id);

            if(catgoriaEncontrada == null) {
                throw new NoSuchElementException("O id informado '" + id + "' da CategoriaMeme não foi encontrado");
            }

            return ResponseEntity.ok(catgoriaEncontrada);
        }catch (Exception ex) {
            log.error("[MEMELANDIA][CATEGORIA_MEME][BUSCAR_CATEGORIA_POR_ID] Erro ao buscar categoria de meme por id: {}", ex.getMessage());
            throw new MemeException();
        }
    }

    @Override
    public ResponseEntity<List<CategoriaMeme>> listarTodasCategorias() {
        try {
            return ResponseEntity.ok(repository.findAll());
        }catch (Exception ex) {
            log.error("[MEMELANDIA][CATEGORIA_MEME][LISTAR_TODAS_AS_CATEGORIAS] Erro ao listar todas as categorias de meme: {}", ex.getMessage());
            throw new MemeException();
        }
    }

    @Override
    public ResponseEntity<CategoriaMeme> buscarCategoriaMemePorNome(String nome) {
        try {

            if(nome.isBlank()) {
                throw new MemeException("O id não pode ser nulo ou vázio");
            }

            CategoriaMeme catgoriaEncontrada = repository.findCategoriaMemeByNome(nome);

            if(catgoriaEncontrada == null) {
                throw new NoSuchElementException("O nome informado '" + nome + "' da CategoriaMeme não foi encontrado");
            }

            return ResponseEntity.ok(catgoriaEncontrada);
        }catch (Exception ex) {
            log.error("[MEMELANDIA][CATEGORIA_MEME][BUSCAR_CATEGORIA_POR_NOME] Erro ao buscar categoria de meme por nome: {}", ex.getMessage());
            throw new MemeException();
        }
    }

    private void validarObjetoCategoriaMeme(CategoriaMeme categoria) {
        if(categoria == null) {
            throw new MemeException("A CategoriaMeme não pode ser nulo");
        }

        if(categoria.getUsuarioId() == null) {
            throw new MemeException("O id do usuário não pode ser nulo");
        }
    }
}
