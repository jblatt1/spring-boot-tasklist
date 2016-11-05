package tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasklist.models.Task;
import tasklist.models.TaskList;
import tasklist.repos.TaskListRepository;

import java.util.*;

@Service
public class TaskListService {
	@Autowired
	private TaskListRepository taskListRepo;
	
    public Collection<TaskList> getAllLists() {
        return (Collection<TaskList>) taskListRepo.findAll();
    }

    public TaskList createTaskList(TaskList taskList) {
    	return taskListRepo.save(taskList);
    }

    public TaskList getList(String id) {
    	return taskListRepo.findOne(id);
    }

    public TaskList updateList(TaskList taskList) {
    	return taskListRepo.save(taskList);
    }
    
    public void delete(String id){
    	 taskListRepo.delete(id);
    }
}
