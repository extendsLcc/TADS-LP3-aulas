package DataAccessLayer.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class MyDAO<MyDTO> {
    MyDataBase myConnection;

    public MyDAO() throws SQLException {
        myConnection = MyDataBase.getInstance();
    }

    public ResultSet executeSQL(String sql) throws SQLException {
        ResultSet rs = myConnection.executeSQL(sql);
        if(!rs.next()) {
            throw new SQLException("Erro ao executar: " + sql);
        }
        return rs;
    }

    public Connection getConnection() {
        return this.myConnection.getConnection();
    }

    // CRUD
    abstract void create(MyDTO myobject) throws SQLException;
    abstract void delete(int id) throws SQLException;
    abstract MyDTO get(int id) throws SQLException;
    abstract void update(MyDTO myobject) throws SQLException;

    abstract List<MyDTO> list() throws SQLException;
    abstract List<MyDTO> list(String pattern) throws SQLException;
    abstract List<MyDTO> list(List<Integer> ids) throws SQLException;
}
