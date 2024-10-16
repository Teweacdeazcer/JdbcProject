package jdbc;

import java.sql.Connection;

public class MainJDBCTest {
    public static void main(String[] args) {
        Connection con = JDBCConnector.getConnection();
    }
}
