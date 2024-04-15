/**
 *
 */
package br.com.vitoria.dao;

import br.com.vitoria.dao.generic.IGenericDAO;
import br.com.vitoria.domain.Venda;
import br.com.vitoria.exceptions.TipoChaveNaoEncontradaException;


public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
