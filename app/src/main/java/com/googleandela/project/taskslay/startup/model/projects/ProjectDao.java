package com.googleandela.project.taskslay.startup.model.projects;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ProjectDao {  // DAOs must either be interfaces or abstract classes.

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)    /// @Delete and @Update
    void insert(Project projec);

    @Query("DELETE FROM project_table")
    void deleteAll();

    @Query("SELECT * from project_table ORDER BY id  DESC")  //ASC
    LiveData< List<Project> > getAllProjects();
}
