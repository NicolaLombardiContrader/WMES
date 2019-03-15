package it.contrader.wmesspring.converter;

//TODO
import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.TaskTemplateDTO;
import it.contrader.wmesspring.model.TaskTemplate;

public class ConverterTaskTemplate {

	public static TaskTemplateDTO toDTO(TaskTemplate taskTemplate) {
		TaskTemplateDTO taskTemplateDTO = null;
		if (taskTemplate != null) {
			taskTemplateDTO = new TaskTemplateDTO();
			
			taskTemplateDTO.setTaskTemplateId(taskTemplate.getTaskTemplateId());
			taskTemplateDTO.setUserDTO(ConverterUser.toDTO(taskTemplate.getUser()));
			taskTemplateDTO.setResourceDTO(ConverterResource.toDTO(taskTemplate.getResource()));
			taskTemplateDTO.setTaskTemplateAction(taskTemplate.getTaskTemplateAction());
			taskTemplateDTO.setTaskTemplateDescription(taskTemplate.getTaskTemplateDescription());
			taskTemplateDTO.setTaskTemplateTime(taskTemplate.getTaskTemplateTime());
			taskTemplateDTO.setTaskTemplateState(taskTemplate.getTaskTemplateState());
					
		}
		return taskTemplateDTO;
	}

	public static TaskTemplate toEntity(TaskTemplateDTO taskTemplateDTO) {
		TaskTemplate taskTemplate = null;
		if (taskTemplateDTO != null) {
			taskTemplate = new TaskTemplate();
			taskTemplate.setTaskTemplateId(taskTemplateDTO.getTaskTemplateId());
			taskTemplate.setUser(ConverterUser.toEntity(taskTemplateDTO.getUserDTO()));
			taskTemplate.setResource(ConverterResource.toEntity(taskTemplateDTO.getResourceDTO()));
			taskTemplate.setTaskTemplateAction(taskTemplateDTO.getTaskTemplateAction());
			taskTemplate.setTaskTemplateDescription(taskTemplateDTO.getTaskTemplateDescription());
			taskTemplate.setTaskTemplateTime(taskTemplateDTO.getTaskTemplateTime());
			taskTemplate.setTaskTemplateState(taskTemplateDTO.getTaskTemplateState());
		}
		return taskTemplate;
	}

	public static List<TaskTemplateDTO> toListDTO(List<TaskTemplate> list) {
		List<TaskTemplateDTO> listTaskTemplateDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TaskTemplate taskTemplate : list) {
				listTaskTemplateDTO.add(ConverterTaskTemplate.toDTO(taskTemplate));
			}
		}
		return listTaskTemplateDTO;
	}

	public static List<TaskTemplate> toListEntity(List<TaskTemplateDTO> listTaskTemplateDTO) {
		List<TaskTemplate> list = new ArrayList<>();
		if (!listTaskTemplateDTO.isEmpty()) {
			for (TaskTemplateDTO taskTemplateDTO : listTaskTemplateDTO) {
				list.add(ConverterTaskTemplate.toEntity(taskTemplateDTO));
			}
		}
		return list;
	}

}
