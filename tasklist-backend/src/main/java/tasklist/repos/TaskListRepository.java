package tasklist.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import tasklist.models.TaskList;

/**
 *A Spring Data JPA Repository interface for CRUD operations on 
 *{@link TaskList} objects. No implementation is needed as the the 
 *queries are constructed and ran by Spring based off of the method signatures.
 *
 */
@Transactional
public interface TaskListRepository extends CrudRepository<TaskList, String>{
	
	
}
