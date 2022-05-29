package Persistence;

import java.sql.*;

public class CupomPersistence {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/farmacia";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Biblioteca importada");
            Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado com o banco de dados");

            String sql = "SELECT * FROM cupons";
            PreparedStatement stmt = con.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                Date validade = rs.getDate("validade");
                String codigo = rs.getString("codigo");
                String valor = rs.getString("valor");
                System.out.printf("Cupom %s  com validade %s com codigo %s", nome, validade, codigo, valor);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
