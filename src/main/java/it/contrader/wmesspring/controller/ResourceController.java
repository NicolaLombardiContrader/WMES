package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Resource")
public class ResourceController {

	private final ResourceService resourceService;


	@Autowired
	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}



	@RequestMapping(value = "/resourceManagement", method = RequestMethod.GET)
	public List<ResourceDTO> resourceManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOResourceList = new UserDTO();
		userDTOResourceList.setUserId(userId);
		return this.resourceService.findResourceDTOByUser(userDTOResourceList);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "resourceId") int id) {
		this.resourceService.deleteResourceById(id);
		
	}


	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ResourceDTO> insert(@RequestParam(value = "utente") UserDTO userLogged,
			@RequestParam(value = "resource_name") String resourceName,
			@RequestParam(value = "resource_username") String resourceUsername,
			@RequestParam(value = "resource_pass") String resourcePass) {

		
		ResourceDTO resourceDTO = new ResourceDTO();
		resourceDTO.setUserDTO(userLogged);
		resourceDTO.setResourceName(resourceName);
		resourceDTO.setResourceUsername(resourceUsername);
		resourceDTO.setResourcePass(resourcePass);
		resourceService.insertResource(resourceDTO);
		
		return this.resourceService.getListaResourceDTO();

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ResourceDTO read(@RequestParam(value = "resourceId") int id) {
		ResourceDTO resourceUpdate = new ResourceDTO();
		resourceUpdate = this.resourceService.getResourceDTOById(id);
		return resourceUpdate;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ResourceDTO> update(@RequestParam(value = "resource_id") int idUpdate,
			@RequestParam(value = "utente") UserDTO userLogged,
			@RequestParam(value = "resource_name") String nameUpdate,
			@RequestParam(value = "resource_username") String usernameUpdate,
			@RequestParam(value = "resource_pass") String passUpdate) {

		ResourceDTO resource = new ResourceDTO();
		resource.setResourceId(idUpdate);
		resource.setUserDTO(userLogged);
		resource.setResourceName(nameUpdate);
		resource.setResourceUsername(usernameUpdate);
		resource.setResourcePass(passUpdate);

		resourceService.updateResource(resource);
		return this.resourceService.getListaResourceDTO();

	}

	// Resource Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResourceDTO loginControl(@RequestParam(value = "resource_username") String username,
			@RequestParam(value = " resource_pass") String pass) {
	
		final ResourceDTO resourceDTO = resourceService.findResourceByResourceUsernameAndResourcePass(username, pass);
		if (!StringUtils.isEmpty(resourceDTO)) {
			return resourceDTO;
		}
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {
	
	}
	
	

}