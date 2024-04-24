package br.com.vitoria.dao;

import br.com.vitoria.entity.Marca;

import java.util.List;

public interface IMarcaDao {

    Marca cadastrar(Marca marca);

    Marca buscarMarcaPorNome(String marca);

    List<Marca> listarMarcas();

    void excluirMarca(Marca marca);
}
