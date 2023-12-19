package cadastroclienteswing.dao;

import cadastroclienteswing.entity.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set;

    public ClienteSetDAO() {
        set = new HashSet<>();
    }

    @Override
    public Boolean cadatrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void exluir(Long cpf) {
        for (Cliente cli: this.set) {
            if (cli.getCpf().equals(cpf)) {
                this.set.remove(cli);
                 break;
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente cli: this.set) {
                if (cli.equals(cliente)) {
                    cli.setNome(cliente.getNome());
                    cli.setTelefone(cliente.getTelefone());
                    cli.setCpf(cliente.getCpf());
                    cli.setEndereco(cliente.getEndereco());
                    cli.setCidade(cliente.getCidade());
                    cli.setEstado(cliente.getEstado());
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        Cliente cliente = null;
        for (Cliente cli: this.set) {
            if (cli.getCpf().equals(cpf)) {
                cliente = cli;
            }
        }
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}
