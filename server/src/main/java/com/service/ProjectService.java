package com.service;

import com.entity.Projects;
import com.repository.ProjectRepository;

public class ProjectService {
    private ProjectRepository projectrepository;

    public Iterable<Projects> getAllProjects(){

        return projectrepository.findAll();
    }
    public void postproj(Projects project){
        projectrepository.save(project);
    }
}
