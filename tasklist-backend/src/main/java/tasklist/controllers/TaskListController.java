package tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tasklist.models.TaskList;
import tasklist.service.TaskListService;

import java.util.*;

@RestController
@RequestMapping("/lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody TaskList createTaskList(@RequestBody TaskList taskList) {
        return this.taskListService.createTaskList(taskList);
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
    public TaskList updateList(@PathVariable("id") String id, @RequestBody TaskList taskList) {
        return this.taskListService.updateList(taskList);
    }
}
