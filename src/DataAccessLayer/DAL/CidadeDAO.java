package DataAccessLayer.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends MyDAO<Cidade> {

    public CidadeDAO() throws SQLException {
        super();
    }

    public void create(Cidade cidade) throws SQLException {

        String sql = "INSERT INTO tb_cidade ( nome, id_estado) VALUES ( ?, ? )";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, cidade.nome);
        preparedStatement.setInt(2, cidade.id_estado);
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            cidade.id = resultSet.getInt(1);
        }
        preparedStatement.close();

    }

    void delete(int id) throws SQLException {

        String sql = "DELETE FROM tb_cidade WHERE id_cidade = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public Cidade get(int id) throws SQLException {
        String sql = "SELECT id_cidade as id, nome, id_estado " +
            "FROM tb_cidade as cidade " +
            "WHERE id_cidade = " + id;

        ResultSet rs = this.executeSQL(sql);

        Cidade cidade = new Cidade();
        cidade.id = rs.getInt("id");
        cidade.nome = rs.getString("nome");
        cidade.id_estado = rs.getInt("id_estado");

        return cidade;

    }

    void update(Cidade cidade) throws SQLException {

        String sql = "UPDATE FROM tb_cidade SET nome = ?, id_estado = ?  WHERE id = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, cidade.nome);
        preparedStatement.setInt(2, cidade.id_estado);
        preparedStatement.setInt(3, cidade.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    List<Cidade> list() throws SQLException {

        String sql = "SELECT id_cidade, nome, id_estado FROM tb_cidade";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    List<Cidade> list(String pattern) throws SQLException {

        String sql = "SELECT id_cidade, nome, id_estado FROM tb_cidade WHERE nome LIKE '%?%'";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    List<Cidade> list(List<Integer> ids) throws SQLException {

        String sql = "SELECT id_cidade, nome, id_estado FROM tb_cidade WHERE id_cidade IN ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setArray(
            1,
            this.getConnection().createArrayOf("VARCHAR", ids.toArray())
        );
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    private List<Cidade> retrieveListFromPreparedStatement(PreparedStatement preparedStatement) throws SQLException {

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Cidade> cidades = new ArrayList<>();

        while (resultSet.next()) {

            Cidade cidade = new Cidade();
            cidade.id = resultSet.getInt("id_cidade");
            cidade.nome = resultSet.getString("nome");
            cidade.id_estado = resultSet.getInt("id_estado");
            cidades.add(cidade);

        }

        preparedStatement.close();
        return cidades;

    }

}
