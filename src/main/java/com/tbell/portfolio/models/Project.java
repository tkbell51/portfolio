package com.tbell.portfolio.models;

public class Project {
    private long id;
    private String title;
    private String description;
    private String project_language;
    private String url;
    private String projectIMG;

    public Project() {}

    public Project(long id, String title, String description, String project_language, String url, String projectIMG) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.project_language = project_language;
        this.url = url;
        this.projectIMG = projectIMG;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject_language() {
        return project_language;
    }

    public void setProject_language(String project_language) {
        this.project_language = project_language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProjectIMG() {
        return projectIMG;
    }

    public void setProjectIMG(String projectIMG) {
        this.projectIMG = projectIMG;
    }
}
