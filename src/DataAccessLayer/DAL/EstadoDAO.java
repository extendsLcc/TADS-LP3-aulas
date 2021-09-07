package DataAccessLayer.DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO extends MyDAO<Estado> {
    public EstadoDAO() throws SQLException {
        super();
    }

    public void create(Estado myobject) throws SQLException {

        String sql = "INSERT INTO tb_estado ( nome_estado ) VALUES ( ? )";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, myobject.nome);
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            myobject.id = resultSet.getInt(1);
        }
        preparedStatement.close();

    }

    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM tb_estado WHERE id_estado = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public Estado get(int id) throws SQLException {
        String sql = "SELECT id, nome FROM tb_estado WHERE estado_id = " + id;
        ResultSet rs = this.executeSQL(sql);

        Estado estado = new Estado();
        estado.id = rs.getInt("id");
        estado.nome = rs.getString("nome");

        return estado;
    }

    void update(Estado myobject) throws SQLException {

        String sql = "UPDATE FROM tb_estado SET nome_estado = ? WHERE id = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, myobject.nome);
        preparedStatement.setInt(2, myobject.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public List<Estado> list() throws SQLException {

        String sql = "SELECT id_estado, nome_estado FROM tb_estado";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    List<Estado> list(String pattern) throws SQLException {

        String sql = "SELECT id_estado, nome_estado FROM tb_estado WHERE nome_estado LIKE '%?%'";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, pattern);
        return this.retrieveListFromPreparedStatement( preparedStatement );

    }

    List<Estado> list(List<Integer> ids) throws SQLException {

        String sql = "SELECT id_estado, nome_estado FROM tb_estado WHERE id_estado IN ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setArray(
            1,
            this.getConnection().createArrayOf( "VARCHAR", ids.toArray() )
        );
        return this.retrieveListFromPreparedStatement( preparedStatement );

    }

    private List<Estado> retrieveListFromPreparedStatement(PreparedStatement preparedStatement) throws SQLException {

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Estado> estados = new ArrayList<>();

        while (resultSet.next()) {

            Estado estado = new Estado();
            estado.id = resultSet.getInt("id_estado");
            estado.nome = resultSet.getString("nome_estado");
            estados.add(estado);

        }

        preparedStatement.close();
        return estados;

    }

}
