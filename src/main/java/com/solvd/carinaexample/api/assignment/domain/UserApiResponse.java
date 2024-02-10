package com.solvd.carinaexample.api.assignment.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApiResponse {
    private List<RandomUser> results;
    private Info info;

    public List<RandomUser> getResults() {
        return results;
    }

    public void setResults(List<RandomUser> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
