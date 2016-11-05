package tasklist.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tasklist.models.TaskList;
import tasklist.repos.TaskListRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class TaskListServiceTest {
	@Autowired 
	private TaskListService taskListService;
	@MockBean
	private TaskListRepository taskListRepo;
	
	@Test
	public void testGetAllLists(){
		TaskList taskList = new TaskList();
		TaskList taskList2 = new TaskList();
		Collection<TaskList> expectedLists = new LinkedList<TaskList>(Arrays.asList(taskList, taskList2));
		
		given(this.taskListRepo.findAll()).willReturn(expectedLists);
		
		Collection<TaskList> foundLists = this.taskListService.getAllLists();
		assertEquals(foundLists, expectedLists);
	}
}
