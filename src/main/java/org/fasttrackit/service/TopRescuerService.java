package org.fasttrackit.service;

import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.persistence.TopRescuerRepository;
import org.fasttrackit.transfer.TopRescuerListResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TopRescuerService {

    private TopRescuerRepository topRescuerRepository = new TopRescuerRepository();

    public void createTopRescuer(TopRescuer topRescuer) throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Creating top winner entry: " + topRescuer);
        topRescuerRepository.createTopRescuer(topRescuer);
    }
    public TopRescuerListResponse getTopRescuers() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving top winners.");
        List<TopRescuer> topWinners = topRescuerRepository.getTopRescuers();
        return new TopRescuerListResponse(topWinners);
    }
}
