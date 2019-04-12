package org.fasttrackit.persistence;

import org.fasttrackit.Animal;
import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.transfer.SaveTopRescuerRequest;
import org.fasttrackit.transfer.UpdateTopRescuerRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopRescuerRepository {


    public void createTopRescuer(SaveTopRescuerRequest request) throws SQLException, IOException, ClassNotFoundException {
        try(Connection connection = DatabaseConfiguration.getConnection())
        {
            String insertSql = "INSERT INTO top_rescuers (`name`, rescuedAnimalName, wonGames) VALUES (?, ?, ?)" + " ON DUPLICATE KEY UPDATE wonGames = wonGames+1";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setObject(2, request.getRescuedAnimalName());
            preparedStatement.setInt(3, request.getWonGames());

            preparedStatement.executeUpdate();
        }
    }
    public List<TopRescuer> getTopRescuers() throws SQLException, IOException, ClassNotFoundException {
        try (Connection connection = DatabaseConfiguration.getConnection()) {

            String query = "SELECT id, `name`, rescuedAnimalName, wonGames FROM top_rescuers ORDER BY wonGames DESC"; //tilda (`) reserved keyword for name

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<TopRescuer> response = new ArrayList<>();

            while (resultSet.next()) {
                TopRescuer topRescuer = new TopRescuer();
                topRescuer.setId(resultSet.getLong("id"));
                topRescuer.setName(resultSet.getString("name"));
                topRescuer.setRescuedAnimalName(resultSet.getString("rescuedAnimalName"));
                topRescuer.setWonGames(resultSet.getInt("wonGames"));

                response.add(topRescuer);
            }
            return response;
        }
    }

    public void updateTopRescuer(long id, UpdateTopRescuerRequest request) throws SQLException, IOException, ClassNotFoundException {
        try(Connection connection = DatabaseConfiguration.getConnection())
        {
            String updateSql = "UPDATE top_rescuers SET `name` = ?, rescuedAnimalName = ?, wonGames = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setLong(4, id);
            preparedStatement.setString(1,request.getName());
            preparedStatement.setString(2,request.getRescuedAnimalName());
            preparedStatement.setInt(3,request.getWonGames());


            preparedStatement.executeUpdate();
        }
    }
    public void deleteTopRescuer(long id) throws SQLException, IOException, ClassNotFoundException {
        try(Connection connection = DatabaseConfiguration.getConnection())
        {
            String deleteSql = "DELETE FROM top_rescuers WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }
}
