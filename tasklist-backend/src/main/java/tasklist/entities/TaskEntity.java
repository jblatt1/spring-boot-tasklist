package tasklist.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="tasks")
@Entity
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_ID")
	private String id;
	
	@NotNull
    private String desc;
	
	@NotNull
    private Date createdDate;
	
    private boolean complete;

    
    public TaskEntity(){
    	
    }
    
    public TaskEntity(String id, String desc, Date createdDate, boolean complete) {
		this.id = id;
		this.desc = desc;
		this.createdDate = createdDate;
		this.complete = complete;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
}
