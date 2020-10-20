package com.googleandela.project.taskslay.startup.model.projects;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.googleandela.project.taskslay.startup.model.TaskSlayRoomDatabase;

import java.util.List;

public class ProjectRepository {



    private ProjectDao mProjectDao;
    private LiveData<List<Project>> mAllProjects;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
   public ProjectRepository(Application application) {
        TaskSlayRoomDatabase db = TaskSlayRoomDatabase.getDatabase(application);
        mProjectDao = db.projectDao();
        mAllProjects = mProjectDao.getAllProjects();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
  public   LiveData<List<Project>> getAllProjects() {
        return mAllProjects;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Project project) {
        TaskSlayRoomDatabase.databaseWriteExecutor.execute(() -> {
            if(insertedONline()){
            mProjectDao.insert(project);
            }else{
                project.setStatus(Status.OFFLINE);
                mProjectDao.insert(project);

            }
        });
    }

    private boolean insertedONline() {

        return false;
    }

}
