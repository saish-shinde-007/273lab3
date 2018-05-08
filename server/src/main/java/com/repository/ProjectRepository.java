package com.repository;
import java.util.*;
import com.entity.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository <Projects, Long> {
List<Projects> save(String projectname, String skills, String projectDescription, String Budget);

}