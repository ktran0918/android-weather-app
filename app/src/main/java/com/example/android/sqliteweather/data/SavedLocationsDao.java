package com.example.android.sqliteweather.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SavedLocationsDao {
    @Insert
    void insert(String location);

    @Query("SELECT * FROM locations")
    LiveData<List<String>> getAllLocations();
}
