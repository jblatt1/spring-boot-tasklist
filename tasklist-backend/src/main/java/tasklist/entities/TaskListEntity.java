package tasklist.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import tasklist.models.Task;

@Entity
@Table(name="task_lists")
public class TaskListEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_LIST_ID")
	private String id;
	
	@NotNull
	private String name;
	
	@OneToMany
	@JoinColumn(name="TASK_LIST_ID", referencedColumnName="TASK_ID")
    private List<Task> taskList;
	
	
	public TaskListEntity(){}
	
    public TaskListEntity(String id, String name, List<Task> taskList) {
		this.id = id;
		this.name = name;
		this.taskList = taskList;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
