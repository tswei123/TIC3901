import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.File;
import java.io.IOException;

public class Connect {
    private Connection conn = null;

    private Connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:C:\\Users\\User\\Desktop\\test SQL\\Test\\DiaryEntry.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        setConnection(conn);
    }
    public void setConnection(Connection conn){
        this.conn = conn;
    }

}
