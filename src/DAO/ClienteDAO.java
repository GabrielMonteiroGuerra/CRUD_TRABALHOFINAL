package DAO;

import java.util.List;

import Entity.Cliente;

public interface ClienteDAO {
    void inserir(Cliente ce);
    List<Cliente> consultar(String nome);
}
