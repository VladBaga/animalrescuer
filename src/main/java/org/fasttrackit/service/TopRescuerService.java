package org.fasttrackit.service;

import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.persistence.TopRescuerRepository;
import org.fasttrackit.transfer.SaveTopRescuerRequest;
import org.fasttrackit.transfer.TopRescuerListResponse;
import org.fasttrackit.transfer.UpdateTopRescuerRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TopRescuerService {

    private TopRescuerRepository topRescuerRepository = new TopRescuerRepository();

    public void createTopRescuer(SaveTopRescuerRequest request) throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Creating top winner entry: " + request);
        topRescuerRepository.createTopRescuer(request);
    }
    public TopRescuerListResponse getTopRescuers() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving top winners.");
        List<TopRescuer> topWinners = topRescuerRepository.getTopRescuers();
        return new TopRescuerListResponse(topWinners);
    }
    public void updateTopRescuer(long id, UpdateTopRescuerRequest request) throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Updating top winner entry: " + request);
        topRescuerRepository.updateTopRescuer(id, request);
        System.out.println("Updated top winner entry: " + request);

    }
    public void deleteTopRescuer(long id) throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Deleting top winner entry: " + id);
        topRescuerRepository.deleteTopRescuer(id);
        System.out.println("Deleted top winner entry: " + id);

    }
}
