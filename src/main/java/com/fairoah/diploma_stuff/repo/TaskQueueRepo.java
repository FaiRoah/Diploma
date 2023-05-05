package com.fairoah.diploma_stuff.repo;

import org.apache.tomcat.util.threads.TaskQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fairoah.diploma_stuff.repo.models.Task;
import com.fairoah.lib.DataBaseAccess;

public interface TaskQueueRepo extends JpaRepository<Task, Long>{
	public static String DB_PATH = "diploma_testing_stuff";
	public static String TABLE_NAME = "task";
	@Transactional
	@Modifying
//	@Query(value = "DELETE FROM " + DB_PATH + "." + TABLE_NAME + " WHERE taskID IN"
//			+ " (SELECT * FROM (SELECT taskID FROM " + DB_PATH + "." + TABLE_NAME +
//			" LIMIT 1) as p)",
//			nativeQuery = true)
	@Query(value="DELETE FROM " + DB_PATH + "." + TABLE_NAME + " LIMIT 1", 
		   nativeQuery = true)
	public void deleteFirst1();
	
	@Query(value="SELECT * FROM " + DB_PATH + "." + TABLE_NAME +" LIMIT 1",
			nativeQuery = true)
	public Task findFirst();
	
	@Query(value="SELECT * FROM " + DB_PATH + "." + TABLE_NAME 
			+ " WHERE `handler` = ?1 LIMIT 1",
			nativeQuery = true)
	public Task findTask(String handler);
	
	
}
