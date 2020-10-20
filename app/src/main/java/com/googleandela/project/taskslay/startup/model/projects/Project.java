package com.googleandela.project.taskslay.startup.model.projects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//When you modify the database schema, you'll need to update the version number and define a migration strategy
@Entity(tableName = "project_table")
public class Project {
    @PrimaryKey            //// @PrimaryKey(autoGenerate = true) private int id;
    @NonNull
    @ColumnInfo(name = "id")
    private long id;
    @Nullable
    @ColumnInfo(name = "name")
    private String name;
    @Nullable
    @ColumnInfo(name = "description")
    private String description;
    @Nullable
    @ColumnInfo(name = "skills")
    private String skills;
    @Nullable
    @ColumnInfo(name = "edited_id")
    private long edited_id;
    @Nullable
    @ColumnInfo(name = "status")
    private int status;


    public Project(long id, @Nullable String name, @Nullable String description, @Nullable String skills, long edited_id, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skills = skills;
        this.edited_id = edited_id;
        this.status = status;
    }


    @Nullable
    public String getSkills() {
        return skills;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public void setSkills(@Nullable String skills) {
        this.skills = skills;
    }

    public void setEdited_id(long edited_id) {
        this.edited_id = edited_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public long getId() {
        return id;
    }
    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public long getEdited_id() {
        return edited_id;
    }
}
