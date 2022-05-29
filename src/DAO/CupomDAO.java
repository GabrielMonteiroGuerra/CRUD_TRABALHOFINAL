package DAO;

import java.util.List;

import Entity.Cupom;

public interface CupomDAO {
    void inserir(Cupom c);
    List<Cupom> consultar(String nome);
}
