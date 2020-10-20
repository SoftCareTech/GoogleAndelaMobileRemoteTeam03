package com.googleandela.project.taskslay.startup.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.googleandela.project.taskslay.startup.model.projects.Project;
import com.googleandela.project.taskslay.startup.model.projects.ProjectDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//When you modify the database schema, you'll need to update the version number and define a migration strategy
@Database(entities = {Project.class}, version = 1, exportSchema = false)
public abstract class TaskSlayRoomDatabase extends RoomDatabase {

    public abstract ProjectDao projectDao();

    private static volatile TaskSlayRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TaskSlayRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskSlayRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),  TaskSlayRoomDatabase.class, "task_slay_database")
                            ///addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}