package org.max.issuetracker.web.dto;

import org.max.issuetracker.domain.model.Project;

public class ProjectWebMapper {

    public static ProjectDTO toDTO(Project p){
        return new ProjectDTO(
                p.getId(),
                p.getName(),
                p.getProjectKey(),
                p.getDescription(),
                p.getOwnerId()
        );
    }
}
