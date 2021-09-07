package DataAccessLayer.DAL;

import java.sql.*;

public class MyDataBase {
    // responsavel pela conexao apenas...
    Connection conn = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost:3306/loja_joaquim";
    String user = "marcelo";
    String pwd = "aaa";

    protected static MyDataBase INSTANCE = null;

    public static MyDataBase getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new MyDataBase();
        }
        return INSTANCE;
    }

    protected MyDataBase() throws SQLException {
        conn = DriverManager.getConnection(url, user, pwd);
        stmt = conn.createStatement();
    }

    public ResultSet executeSQL(String sql) throws SQLException {
        ResultSet rs;
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public Connection getConnection() {
        return this.conn;
    }

}
