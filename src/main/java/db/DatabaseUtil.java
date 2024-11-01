package db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public final class DatabaseUtil {

    public static void test(String query) {
        try {
            InputStream is = new FileInputStream("src/main/java/db/config.properties");

            Properties p = new Properties();
            Class.forName("com.mysql.jdbc.Driver");
            p.load(is);

            String url =p.getProperty("db.url");
            String username = p.getProperty("db.user");
            String password = p.getProperty("db.password");


            Connection c = DriverManager.getConnection(
                    url, username, password);

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next())
                System.out.println(rs.getString(2));
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
