package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterResource;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ResourceRepository;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.User;

@Service
public class ResourceService {

	private final ResourceRepository resourceRepository;

	@Autowired
	public ResourceService(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	public List<ResourceDTO> getListaResourceDTO() {
		return ConverterResource.toListDTO((List<Resource>) resourceRepository.findAll());
	}

	public ResourceDTO getResourceDTOById(Integer id) {
		return ConverterResource.toDTO(resourceRepository.findById(id).get());
	}

	public boolean insertResource(ResourceDTO resourceDTO) {

		return resourceRepository.save(ConverterResource.toEntity(resourceDTO)) != null;
	}

	public boolean updateResource(ResourceDTO resourceDTO) {
		return resourceRepository.save(ConverterResource.toEntity(resourceDTO)) != null;
	}

	public void deleteResourceById(Integer id) {
		resourceRepository.deleteById(id);
	}

	//////////////////////////////////////////////////////////////////////////////////
	public List<ResourceDTO> findResourceDTOByUser(UserDTO userDTO) {

		final List<Resource> listResource = resourceRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ResourceDTO> listResourceDTO = new ArrayList<>();
		listResource.forEach(i -> listResourceDTO.add(ConverterResource.toDTO(i)));
		return listResourceDTO;
	}
	
	public ResourceDTO findResourceByResourceUsernameAndResourcePass(String username, String password) {

		final Resource resource = resourceRepository.findResourceByResourceUsernameAndResourcePass(username, password);

		return ConverterResource.toDTO(resource);
	}

}
