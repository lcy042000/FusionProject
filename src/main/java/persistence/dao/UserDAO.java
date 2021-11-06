package persistence.dao;

import persistence.dto.UserDTO;

import java.sql.*;

public class UserDAO {

    protected static Connection conn = null;
    protected static Statement stmt = null;
    protected static PreparedStatement pstmt = null;
    protected static ResultSet rs = null;

    protected void connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/FusionProject";
            conn = DriverManager.getConnection(url, "root", "lcy556622@");

        }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        catch (SQLException throwables) { throwables.printStackTrace(); }

    }

    protected void closeResultSet() {
        try { if(conn != null && !rs.isClosed()){ rs.close(); } }
        catch (SQLException throwables) { throwables.printStackTrace(); }
    }

    protected void closeStmt() {
        try { if(conn != null && !stmt.isClosed()){ stmt.close(); } }
        catch (SQLException throwables) { throwables.printStackTrace(); }
    }

    protected void closeConnection() {
        try { if(conn != null && !conn.isClosed()){ conn.close(); } }
        catch (SQLException throwables) { throwables.printStackTrace(); }
    }

    protected void closePstmt() {
        try { if(conn != null && !pstmt.isClosed()){ pstmt.close(); } }
        catch (SQLException throwables) { throwables.printStackTrace(); }
    }

    protected Long insertUser(UserDTO userDTO) {

        connect();

        String query = "INSERT INTO USERS (name, password, phone_number) VALUES (?, ?, ?);";

        try {

            pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userDTO.getName());
            pstmt.setString(2, userDTO.getPassword());
            pstmt.setString(3, userDTO.getPhoneNumber());

            // 전화번호 중복 체크 필요 >> 서비스 딴에서?
            int updatedColumns = pstmt.executeUpdate();

            // if(result == false) throw new SQLException("Creating User Error");

            rs = pstmt.getGeneratedKeys();

            if(rs.next()) return rs.getLong(1);
            // conn.commit();

        }

        catch (SQLException throwables) { throwables.printStackTrace(); }

        // closeResultSet();
        closePstmt();
        closeConnection();

        return -1L;
    }

}
