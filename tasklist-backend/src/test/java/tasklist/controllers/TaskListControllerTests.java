package tasklist.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tasklist.models.Task;
import tasklist.models.TaskList;
import tasklist.service.TaskListService;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskListController.class)
public class TaskListControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private TaskListService taskListService;

	@Test
	public void testCreateTaskList() throws JsonProcessingException, Exception{
		TaskList newList = new TaskList();
		newList.setName("List");
		Task task = new Task();
		task.setCreatedDate(new Date());
		task.setDesc("We have some things to do.");
		newList.setTaskList(Arrays.asList(task));
		ObjectMapper mapper = new ObjectMapper();
		given(this.taskListService.createTaskList(newList)).willReturn(newList);
		this.mockMvc.perform(post("/lists").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(newList)))
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testGetAllLists() throws  Exception{
		TaskList newList = new TaskList();
		newList.setName("List");
		Collection<TaskList> allLists = Arrays.asList(newList);
		given(this.taskListService.getAllLists()).willReturn(allLists);
		this.mockMvc.perform(get("/lists").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	public void testGetList() throws Exception{
		TaskList newList = new TaskList();
		newList.setName("List");
		newList.setId("someId");
		given(this.taskListService.getList(newList.getId())).willReturn(newList);
		this.mockMvc.perform(get("/lists/"+ newList.getId()).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testUpdateList() throws Exception{
		TaskList newList = new TaskList();
		newList.setName("List");
		newList.setId("someId");
		TaskList updatedList = new TaskList();
		updatedList.setId(newList.getId());
		updatedList.setName("new name");
		ObjectMapper mapper = new ObjectMapper();
		given(this.taskListService.updateList(newList)).willReturn(newList);
		
		this.mockMvc.perform(put("/lists/"+ newList.getId()).contentType(MediaType.APPLICATION_JSON_UTF8).content(mapper.writeValueAsBytes(newList)))
				.andExpect(status().is2xxSuccessful());
	}
}
