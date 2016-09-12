package com.gl.petstore.pm;

import javax.jws.WebService;

@WebService(name = "ProjectManager", targetNamespace = "http://pm.petstore.gl.com/", wsdlLocation = "http://pm.petstore.gl.com/ProjectManagerService?wsdl")
public interface ProjectManager {
	String getProjectName();

	String getProjectNameFromName(String projectName);
}
