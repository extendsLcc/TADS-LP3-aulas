package DataAccessLayer.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends MyDAO<Produto> {

    public ProdutoDAO() throws SQLException {
        super();
    }

    @Override
    void create(Produto produto) throws SQLException {

        String sql = "INSERT INTO tb_produto ( nome, valor_unitario ) VALUES ( ?, ? )";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, produto.nome);
        preparedStatement.setDouble(2, produto.valorUnitario);
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            produto.id = resultSet.getInt(1);
        }
        preparedStatement.close();

    }

    @Override
    void delete(int id) throws SQLException {

        String sql = "DELETE FROM tb_produto WHERE id_produto = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    Produto get(int id) throws SQLException {

        String sql = "SELECT id_produto, nome, valor_unitario FROM tb_produto WHERE id_produto = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Produto produto;

        if (resultSet.next()) {

            produto = new Produto();
            produto.id = resultSet.getInt("id_produto");
            produto.nome = resultSet.getString("nome");
            produto.valorUnitario = resultSet.getDouble("valor_unitario");

        } else {
            throw new SQLException("Produto not found!");
        }

        preparedStatement.close();
        return produto;

    }

    @Override
    void update(Produto produto) throws SQLException {


        String sql = "UPDATE FROM tb_produto SET nome = ?, valor_unitario = ? WHERE id_produto = ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, produto.nome);
        preparedStatement.setDouble(2, produto.valorUnitario);
        preparedStatement.setInt(3, produto.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    List<Produto> list() throws SQLException {

        String sql = "SELECT id_produto, nome, valor_unitario FROM tb_produto";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    @Override
    List<Produto> list(String pattern) throws SQLException {

        String sql = "SELECT id_produto, nome, valor_unitario FROM tb_produto WHERE nome LIKE '%?%'";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    @Override
    List<Produto> list(List<Integer> ids) throws SQLException {

        String sql = "SELECT id_produto, nome, valor_unitario FROM tb_produto WHERE id_produto IN ?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
        preparedStatement.setArray(
            1,
            this.getConnection().createArrayOf("VARCHAR", ids.toArray())
        );
        return this.retrieveListFromPreparedStatement(preparedStatement);

    }

    private List<Produto> retrieveListFromPreparedStatement(PreparedStatement preparedStatement) throws SQLException {

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Produto> produtos = new ArrayList<>();

        while (resultSet.next()) {

            Produto produto = new Produto();
            produto.id = resultSet.getInt("id_produto");
            produto.nome = resultSet.getString("nome");
            produto.valorUnitario = resultSet.getDouble("valor_unitario");
            produtos.add(produto);

        }

        preparedStatement.close();
        return produtos;

    }


}
