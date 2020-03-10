package com.example.android.sqliteweather;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android.sqliteweather.data.ForecastLocation;
import com.example.android.sqliteweather.data.SavedLocationsRepository;

import java.util.List;

public class SavedLocationsViewModel extends AndroidViewModel {
    private SavedLocationsRepository mRepository;

    public SavedLocationsViewModel(Application application) {
        super(application);
        mRepository = new SavedLocationsRepository(application);
    }

    public void insertSavedLocation(String locationName) {
        ForecastLocation forecastLocation = new ForecastLocation();
        forecastLocation.location = locationName;
        mRepository.insertSavedLocation(forecastLocation);
    }

//    public void deleteSavedRepo(ForecastLocation location) {
//        mRepository.deleteSavedRepo(location);
//    }

    public LiveData<List<ForecastLocation>> getAllLocations() {
        return mRepository.getAllLocations();
    }

//    public LiveData<ForecastLocation> getRepoByName(String fullName) {
//        return mRepository.getRepoByName(fullName);
//    }
}
