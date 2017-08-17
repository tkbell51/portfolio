package com.tbell.portfolio.Repositories;

import com.tbell.portfolio.interfaces.ProjectRepository;
import com.tbell.portfolio.models.Project;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepositoryImp implements ProjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Project> findAll() {
        return jdbcTemplate.query("SELECT * FROM project", new ProjectMapper());

    }
    @Override
    public List<Project> findByProjectRole (int projectRole) {
        return jdbcTemplate.query("SELECT * FROM project WHERE project_role = ?", new ProjectMapper(), projectRole);
    }

    @Override
    public void add(String title, String description, String project_language, String url, String projectIMG) {
        jdbcTemplate.update("INSERT INTO project (title, description, project_language, url, projectimg) VALUES (?,?,?,?,?)", title, description, project_language, url, projectIMG);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM project WHERE id= ?", id);
    }
    private static class ProjectMapper implements RowMapper<Project> {

        @Override
        public Project mapRow(ResultSet resultSet, int i) throws SQLException {
            Project project = new Project(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("project_language"),
                    resultSet.getString("url"),
                    resultSet.getString("projectIMG"));
            return project;
        }
    }

}
