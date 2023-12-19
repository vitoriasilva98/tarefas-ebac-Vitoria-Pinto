package cadastroclienteswing.dao;

import cadastroclienteswing.dao.IClienteDAO;
import cadastroclienteswing.entity.Cliente;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new TreeMap<>();
    }

    @Override
    public Boolean cadatrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }

        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void exluir(Long cpf) {
        Cliente cliente = this.map.get(cpf);

        this.map.remove(cliente.getCpf());
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente dadosCliente = this.map.get(cliente.getCpf());
        dadosCliente.setNome(cliente.getNome());
        dadosCliente.setCpf(cliente.getCpf());
        dadosCliente.setTelefone(cliente.getTelefone());
        dadosCliente.setNumero(cliente.getNumero());
        dadosCliente.setEndereco(cliente.getEndereco());
        dadosCliente.setCidade(cliente.getCidade());
        dadosCliente.setEstado(cliente.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
