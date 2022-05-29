package Persistence;

import java.sql.*;

public class ClientePersistence {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/farmacia";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Biblioteca importada");
            Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado com o banco de dados");

            String sql = "SELECT * FROM clientes";
            PreparedStatement stmt = con.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                Date datanasc = rs.getDate("Datanasc");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String cpf = rs.getString("cpf");
                System.out.printf("Cliente %s  nascido em %s com cpf %s", nome, datanasc, endereco, telefone, cpf);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
