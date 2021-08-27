package DatabaseConnection;

import Exception.Entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {

            Connection connection = connection = ConnectionFactory.createConnectionToMySQL();

            String sql = "SELECT idProduto, nome, valor_unitario FROM Produto";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Produto produto = new Produto(
                    resultSet.getInt("idProduto"),
                    resultSet.getString("nome"),
                    resultSet.getDouble("valor_unitario"),
                    0
                );

                System.out.println(produto);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
