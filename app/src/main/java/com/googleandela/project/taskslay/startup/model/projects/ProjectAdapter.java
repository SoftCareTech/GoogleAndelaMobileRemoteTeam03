package com.googleandela.project.taskslay.startup.model.projects;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.googleandela.project.taskslay.R;
import com.googleandela.project.taskslay.startup.model.Ut;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.UserViewHolder> {

    private final LayoutInflater mInflater;
    private List<Project> mProjects; // Cached copy of projects
    public ProjectAdapter(Context context) { mInflater = LayoutInflater.from(context); }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_project, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (mProjects != null) {
           Project current = mProjects.get(position);
            holder.name.setText(current.getName());
            holder.decription.setText(current.getDescription());
            holder.skills.setText(current.getSkills());
            holder.started.setText(String.valueOf(Ut.getTime(current.getId())));
        } else {
            // Covers the case of data not being ready yet.
            holder.name.setText("No Project yet");
        }
    }


    @Override
    public int getItemCount() {
        if ( mProjects != null)
            return  mProjects.size();

        return 0;
    }
  public   void setProjects(List<Project> projects){
        mProjects = projects;
        notifyDataSetChanged();
    }






    static class UserViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView decription;
        final TextView skills;
        final TextView started;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            decription = itemView.findViewById(R.id.description);
            skills = itemView.findViewById(R.id.skills);
            started = itemView.findViewById(R.id.started);
        }
    }
}
