package com.googleandela.project.taskslay;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.googleandela.project.taskslay.startup.model.projects.Project;
import com.googleandela.project.taskslay.startup.model.projects.ProjectAdapter;
import com.googleandela.project.taskslay.startup.model.projects.ProjectViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProjectsFragment extends Fragment {

    private ArrayList<Project> projects;
    private ProjectViewModel mProjectViewModel;
   // private RequestQueue mRequestQueue;
    private ProjectAdapter leadersAdapter;
    private Context context;
    private RecyclerView recyclerView;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.project_task_fragment, container, false);

        return rootView;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
       // mRecyclerView = view.findViewById(R.id.list);
       // mRecyclerView.hasFixedSize();
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(context));

       // leaders = new ArrayList<>();

        recyclerView = view.findViewById(R.id.list);
        final ProjectAdapter adapter = new ProjectAdapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mProjectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);

        mProjectViewModel.getAllProjects().observe((LifecycleOwner) context, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable final List<Project> projects) {
                // Update the cached copy of the words in the adapter.
                adapter.setProjects(projects);
            }
        });
       // mRequestQueue = Volley.newRequestQueue(context);

        //call the JSON method
      //  parseJsonData();


    }

}
