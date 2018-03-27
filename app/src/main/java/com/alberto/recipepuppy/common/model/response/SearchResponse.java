package com.alberto.recipepuppy.common.model.response;

import com.alberto.recipepuppy.common.model.SearchDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("title")
    private String title;
    @SerializedName("version")
    private Double version;
    @SerializedName("href")
    private String href;
    @SerializedName("results")
    private List<SearchDTO> results = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<SearchDTO> getResults() {
        return results;
    }

    public void setResults(List<SearchDTO> results) {
        this.results = results;
    }

}