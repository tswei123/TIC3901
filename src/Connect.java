import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;

public class Connect {
    private Connection conn = null;
    private String url;

    public Connect(String path) {
        setURL(path);
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        setConnection(conn);
        createDiaryDB();
    }

    public Connect(String path, String path1) {
        setURL(path);
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        setConnection(conn);
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public void setURL(String path) {
        url = "jdbc:sqlite:" + path;
    }

    public void createDiaryDB() {
        String sql = "CREATE TABLE IF NOT EXISTS 'DiaryEntry' ( 'EntryID' INT, 'Title'	TINYTEXT, " +
                "'Body'	MEDIUMTEXT, " +
                "'Date'	DATE );";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertEntryDB(int entryID, String title, String body, String date) {
        String sql = "INSERT INTO 'DiaryEntry' ('EntryID', 'Title', 'Body', 'Date') VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, entryID);
            pstmt.setString(2, title);
            pstmt.setString(3, body);
            pstmt.setString(4, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEntryDB(int entryID) {
        String sql = "DELETE FROM DiaryEntry WHERE EntryID = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, entryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editEntryDB(int entryID, String title, String body, String date) {
        String sql = "UPDATE DiaryEntry SET Title = ?, Body = ?, Date = ? WHERE EntryID = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, body);
            pstmt.setString(3, date);
            pstmt.setInt(4, entryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadDiary(Diary diary) {
        String sql = "SELECT * FROM DiaryEntry";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int entryID = rs.getInt("EntryID");
                String title = rs.getString("Title");
                String body = rs.getString("Body");
                String date = rs.getString("Date");
                diary.loadEntry(entryID, title, body, date);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, String> loadUser(){
        String sql = "SELECT Username, Password FROM Users";
        HashMap<String, String> loginData = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                loginData.put(rs.getString("Username"), rs.getString("Password"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loginData;
    }

    public void insertUserDB(String username, String name, String email, String password) {
        String sql = "INSERT INTO 'Users' ('Username', 'Name', 'Email', 'Password') VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
/*
    PreparedStatement pstmt=conn.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);*/