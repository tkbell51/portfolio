package com.tbell.portfolio.controllers;


import com.tbell.portfolio.Repositories.ProjectRepositoryImp;
import com.tbell.portfolio.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PortfolioController {


    @Autowired
    private ProjectRepositoryImp repo;

    @RequestMapping("/")
    public String index(Model model){
    Iterable<Project> gabble = repo.findByProjectRole(1);

    model.addAttribute("firstProject", gabble);
    Iterable<Project> projects = repo.findByProjectRole(2);
    model.addAttribute("projects", projects);
    Iterable<Project> lastProject = repo.findByProjectRole(3);
    model.addAttribute("lastProject", lastProject);
        return "index";
    }


    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Project> allProjects = repo.findAll();
        model.addAttribute("projects", allProjects);
        return "admin";
    }

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(@RequestParam("title") String title,
                              @RequestParam("description") String description,
                              @RequestParam("language")String language,
                              @RequestParam("url")String url,
                                @RequestParam("projectIMG")String projectIMG) {
       repo.add(title,description,language,url,projectIMG);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") long id) {
        repo.delete(id);
        return "redirect:/admin";
    }
}