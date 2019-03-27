package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.service.TopRescuerService;
import org.fasttrackit.transfer.TopRescuerListResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/top-rescuers")
public class TopRescuerServlet extends HttpServlet {

private TopRescuerService topRescuerService = new TopRescuerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TopRescuerListResponse topRescuers = topRescuerService.getTopRescuers();

            //serialising or marshalling - transformarea unui obiect intr-un String
            ObjectMapper objectMapper = new ObjectMapper();
            String responseJson = objectMapper.writeValueAsString(topRescuers);

            //content type or mime type
            resp.setContentType("application/json");
            resp.getWriter().print(responseJson);
            resp.getWriter().flush();

        } catch (Exception e) {
            resp.sendError(500,"There was an error processing your request. " + e.getMessage()); //status code = 404 not found
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TopRescuer topRescuer = objectMapper.readValue(req.getReader(), TopRescuer.class);

        try {
            topRescuerService.createTopRescuer(topRescuer);
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TopRescuer topRescuer = objectMapper.readValue(req.getReader(), TopRescuer.class);

        try {
            topRescuerService.updateTopRescuer(topRescuer);
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TopRescuer topRescuer = objectMapper.readValue(req.getReader(), TopRescuer.class);

        try {
            topRescuerService.deleteTopRescuer(topRescuer);
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }
}
