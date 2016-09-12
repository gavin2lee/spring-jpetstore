package com.gl.petstore.pm.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gl.petstore.pm.ProjectManager;
import com.gl.petstore.pm.vo.ProjectVO;

public class ProjectManagerImpl implements ProjectManager {
	ProjectVO project = new ProjectVO();
	Map<String, ProjectVO> projects = new HashMap<String, ProjectVO>();

	public ProjectManagerImpl() {
		project.setId(1L);
		project.setName("Project-A");
		project.setCreateAt(new Date());

		projects.put(project.getName(), project);
	}

	@Override
	public String getProjectName() {
		return project.getName();
	}

	@Override
	public String getProjectNameFromName(String projectName) {
		ProjectVO vo = projects.get(projectName);
		return vo == null? "":vo.getName();
	}

}
