package todo.service;

import org.springframework.stereotype.Service;
import todo.models.Task;
import todo.models.TaskList;

import java.util.*;

@Service
public class TaskListService {

    public Collection<TaskList> getAllLists() {
        HashSet<TaskList> taskLists = new HashSet<>();
        List<Task> listOfTasks = new ArrayList<Task>();
        Task task1 = new Task();
        task1.setId("taskId");
        task1.setComplete(false);
        task1.setDesc("Some task");
        task1.setCreatedDate(new Date());
        listOfTasks.add(task1);
        TaskList taskList1 = new TaskList();
        taskList1.setId("Test");
        taskList1.setName("Hello World");
        taskList1.setTaskList(listOfTasks);
        taskLists.add(taskList1);
        return taskLists;
    }

    public void createTaskList(TaskList taskList) {

    }

    public TaskList getList(String id) {
        return null;
    }

    public void updateList(TaskList taskList) {

    }
}
