package com.example.android.sqliteweather.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SavedLocationsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ForecastLocation forecastLocation);

    @Query("SELECT * FROM locations")
    LiveData<List<ForecastLocation>> getAllLocations();
}
