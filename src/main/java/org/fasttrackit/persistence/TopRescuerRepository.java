package org.fasttrackit.persistence;

import org.fasttrackit.Animal;
import org.fasttrackit.domain.TopRescuer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopRescuerRepository {

    public void createTopRescuer(TopRescuer topRescuer) throws SQLException, IOException, ClassNotFoundException {
        try(Connection connection = DatabaseConfiguration.getConnection())
        {
            String insertSql = "INSERT INTO top_rescuers (`name`, rescuedAnimal, wonGames) VALUES (?, ?, ?)" + " ON DUPLICATE KEY UPDATE wonGames = wonGames+1";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, topRescuer.getName());
            preparedStatement.setString(2, topRescuer.getRescuedAnimal());
            preparedStatement.setInt(3, topRescuer.getWonGames());

            preparedStatement.executeUpdate();
        }
    }
    public List<TopRescuer> getTopRescuers() throws SQLException, IOException, ClassNotFoundException {
        try (Connection connection = DatabaseConfiguration.getConnection()) {

            String query = "SELECT id, `name`, rescuedAnimal, wonGames FROM top_rescuers ORDER BY wonGames DESC"; //tilda (`) reserved keyword for name

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<TopRescuer> response = new ArrayList<>();

            while (resultSet.next()) {
                TopRescuer topRescuer = new TopRescuer();
                topRescuer.setId(resultSet.getLong("id"));
                topRescuer.setName(resultSet.getString("name"));
                topRescuer.setRescuedAnimal(resultSet.getString("rescuedAnimal"));
                topRescuer.setWonGames(resultSet.getInt("wonRaces"));

                response.add(topRescuer);
            }
            return response;
        }
    }
}
