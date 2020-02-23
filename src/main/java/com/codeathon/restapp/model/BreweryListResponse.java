package com.codeathon.restapp.model;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public class BreweryListResponse implements Serializable {
    private Integer currentPage, numberOfPages, totalResults;
    private List<Brewery> data;
    private String status;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Brewery> getData() {
        return data;
    }

    public void setData(List<Brewery> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
