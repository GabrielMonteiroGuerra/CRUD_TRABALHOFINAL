package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {
    private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/farmacia?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";
    private Connection con;

    public ClienteDAOImpl() {
        try {
            Class.forName(JDBC_CLASS);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Cliente ce) {
        String sql = "INSERT INTO clientes (id, nome, DataNasc, endereco, telefone, cpf) ";
        sql += " VALUES (0,?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ce.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(ce.getDataNasc()));
            stmt.setString(3, ce.getEndereco());
            stmt.setString(4, ce.getTelefone());
            stmt.setString(5, ce.getCpf());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Cliente> consultar(String nome) {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE '%" + nome + "%'";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNasc(rs.getDate("datanasc").toLocalDate());
                cliente.setNome(rs.getString("endereco"));
                cliente.setNome(rs.getString("telefone"));
                cliente.setNome(rs.getString("cpf"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
