package todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.models.Task;
import todo.models.TaskList;
import todo.service.TaskListService;

import java.util.*;

@RestController
@RequestMapping("/lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @RequestMapping(method = RequestMethod.POST)
    public void createTaskList(@RequestBody TaskList taskList) {
        this.taskListService.createTaskList(taskList);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TaskList> getAllLists() {
        return this.taskListService.getAllLists();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TaskList getList(@PathVariable("id") String id) {
        return this.taskListService.getList(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateList(@PathVariable("id") String id, @RequestBody TaskList taskList) {
        this.taskListService.updateList(taskList);
    }
}
