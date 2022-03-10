import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.io.File;
import java.io.IOException;

public class Connect {

    public String username;

    public Connect(String username) {
        this.username = username;
    }

    public static void connectToDb(String fileName){
        String url = "jdbc:sqlite:C:/sqlite/" + fileName;

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                //DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                String query = "Select * FROM DiaryEntry";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next()){
                    String username = rs.getString("Title");
                    System.out.format("%s, Title");
                }
                st.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred while connecting MySQL database");
        }
    }

}
