package org.fasttrackit.transfer;

import org.fasttrackit.domain.TopRescuer;

import java.util.List;

public class TopRescuerListResponse {

    private List<TopRescuer> content;

    public TopRescuerListResponse(List<TopRescuer> content) {
        this.content = content;
    }

    public TopRescuerListResponse() {
        //used for unmarshalling or deserialising
    }

    public List<TopRescuer> getContent() {
        return content;
    }

    public void setContent(List<TopRescuer> content) {
        this.content = content;
    }
}
