package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.service.TopRescuerService;
import org.fasttrackit.transfer.SaveTopRescuerRequest;
import org.fasttrackit.transfer.TopRescuerListResponse;
import org.fasttrackit.transfer.UpdateTopRescuerRequest;

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
        setAccessControlHeaders(resp);
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
        setAccessControlHeaders(resp);
        ObjectMapper objectMapper = new ObjectMapper();
        SaveTopRescuerRequest saveTopRescuerRequest = objectMapper.readValue(req.getReader(), SaveTopRescuerRequest.class);

        try {
            topRescuerService.createTopRescuer(saveTopRescuerRequest);
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdateTopRescuerRequest updateTopRescuerRequest = objectMapper.readValue(req.getReader(), UpdateTopRescuerRequest.class);
        String id = req.getParameter("id");
        try {
            topRescuerService.updateTopRescuer(Long.parseLong(id), updateTopRescuerRequest);
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);

        String id = req.getParameter("id");

        try {
            topRescuerService.deleteTopRescuer(Long.parseLong(id));
        } catch (Exception e) {
            resp.sendError(500, "Internal error: " + e.getMessage());
        }
    }

    //for Preflight requests
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}
