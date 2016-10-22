package tasklist.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tasklist.entities.TaskListEntity;

public interface TaskListRepository extends CrudRepository<TaskListEntity, Long>{
	
	public TaskListEntity saveTaskList(TaskListEntity taskListEntity);
	public TaskListEntity getOneById(String id);
	public List<TaskListEntity> findAllTaskLists();
	public TaskListEntity updateTaskList(TaskListEntity taskListEntity);
	public void deleteTaskList(String id);
	
}
