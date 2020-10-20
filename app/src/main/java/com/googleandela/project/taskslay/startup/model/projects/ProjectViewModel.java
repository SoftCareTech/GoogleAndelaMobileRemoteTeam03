package com.googleandela.project.taskslay.startup.model.projects;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProjectViewModel extends AndroidViewModel {

    private ProjectRepository mRepository;

    private LiveData<List<Project>> mAllProjects;

    public ProjectViewModel(Application application) {
        super(application);
        mRepository = new ProjectRepository(application);
        mAllProjects = mRepository.getAllProjects();
    }

    public LiveData<List<Project>> getAllProjects() { return mAllProjects; }

    public void insert(Project project) {
        mRepository.insert(project);
    }
}
