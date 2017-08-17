package com.tbell.portfolio.interfaces;

import com.tbell.portfolio.models.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAll();
    List<Project> findByProjectRole(int projectRole);
    void add(String title, String description, String project_language, String url, String projectIMG);
    void delete(long id);


}
