package br.com.ebac.memelandia_meme.services.impl;

import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import br.com.ebac.memelandia_meme.entities.Meme;
import br.com.ebac.memelandia_meme.exceptions.MemeException;
import br.com.ebac.memelandia_meme.repositories.IMemeRepository;
import br.com.ebac.memelandia_meme.services.ICategoriaMemeService;
import br.com.ebac.memelandia_meme.services.IMemeService;
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
public class MemeService implements IMemeService {

    private final IMemeRepository repository;
    private final ICategoriaMemeService categoriaMemeService;
    private final UsuarioDatabaseValidator usuarioDatabaseValidator;

    @Override
    public ResponseEntity<Meme> novoMeme(Meme meme) {
        try {
            validarObjetoMeme(meme);
            usuarioDatabaseValidator.verifiqueSeUsuarioExiste(meme.getUsuarioId());
            verifiqueSeCategoriaMemeExiste(meme.getCategoriaMeme().getId());
            meme.setDataCadastro(new Date());

            return ResponseEntity.ok(repository.save(meme));
        } catch (Exception ex) {
            log.error("[MEMELANDIA][MEME][NOVO_MEME] Erro ao criar novo meme: {}", ex.getMessage());
            throw new MemeException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<Meme> buscarMemePorId(Long id) {
        try {
            if(id == null) {
                throw new MemeException("O id do meme para pesquisa não pode ser nulo.");
            }

            Optional<Meme> memeEncontrado = repository.findById(id);

            return ResponseEntity.ok(memeEncontrado.orElse(null));
        } catch (Exception ex) {
            log.error("[MEMELANDIA][MEME][BUSCAR_MEME_POR_ID] Erro ao buscar meme por id: {}", ex.getMessage());
            throw new MemeException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<Meme>> listarTodosMemes() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception ex) {
            log.error("[MEMELANDIA][MEME][LISTAR_TODAS_AS_MEME] Erro ao listar todos os meme: {}", ex.getMessage());
            throw new MemeException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<Meme> buscarMemePorNome(String nome) {
        try {
            if(nome.isBlank()) {
                throw new MemeException("O id não pode ser nulo ou vázio");
            }

            Meme memeEncontrado = repository.findMemeByNome(nome);

            if(memeEncontrado == null) {
                throw new NoSuchElementException("O nome informado '" + nome + "' da meme não foi encontrado");
            }

            return ResponseEntity.ok(memeEncontrado);
        } catch (Exception ex) {
            log.error("[MEMELANDIA][MEME][BUSCAR_CATEGORIA_POR_NOME] Erro ao buscar meme por nome: {}", ex.getMessage());
            throw new MemeException(ex.getMessage());
        }
    }

    private void validarObjetoMeme(Meme meme) {
        if(meme == null) {
            throw new MemeException("A CategoriaMeme não pode ser nulo");
        }

        if(meme.getUsuarioId() == null) {
            throw new MemeException("O id do usuário não pode ser nulo");
        }

        if(meme.getCategoriaMeme().getId() == null) {
            throw new MemeException("O id da categoria meme não pode ser nulo");
        }
    }

    private void verifiqueSeCategoriaMemeExiste(Long usuarioId) {
        CategoriaMeme categoriaEncontrada = categoriaMemeService.buscarCategoriaMemePorId(usuarioId).getBody();

        if (categoriaEncontrada == null) {
            throw new NoSuchElementException("Nenhuma categoria meme foi encontrada na base de dados com esse id.");
        }
    }
}
