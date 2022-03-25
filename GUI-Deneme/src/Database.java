import java.sql.*;

public class Database {

    // MYSQL veri tabanı bilgilerinizi kendinize göre düzenlemelisiniz
    // MYSQL JDBC Driver'ı projeye eklemelisiniz
    // MYSQL'de hesap isimli bir tablo oluşturup id eposta parola isminde üç kolon oluşturmalısınız ve örnek veri girmelisiniz

    private final static String host = "jdbc:mysql://localhost:3306";
    private final static String user = "root";
    private final static String password = "12345678";
    private Connection connectionDB = null;

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Projeye dahil edilen Driver'ın tam yolu doğru olmalı
            connectionDB = DriverManager.getConnection(host, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connectionDB;
    }
}
