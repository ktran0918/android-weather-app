package com.example.android.sqliteweather.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SavedLocationsRepository {
    private SavedLocationsDao mDAO;

    public SavedLocationsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mDAO = db.savedLocationsDao();
    }

    public void insertSavedLocation(ForecastLocation location) {
        new InsertAsyncTask(mDAO).execute(location);
    }

//    public void deleteSavedRepo(ForecastLocation location) {
//        new DeleteAsyncTask(mDAO).execute(location);
//    }

    public LiveData<List<ForecastLocation>> getAllLocations() {
        return mDAO.getAllLocations();
    }

//    public LiveData<ForecastLocation> getRepoByName(String fullName) {
//        return mDAO.getRepoByName(fullName);
//    }

    private static class InsertAsyncTask extends AsyncTask<ForecastLocation, Void, Void> {
        private SavedLocationsDao mAsyncTaskDAO;
        InsertAsyncTask(SavedLocationsDao dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(ForecastLocation... locations) {
            mAsyncTaskDAO.insert(locations[0]);
            return null;
        }
    }

//    private static class DeleteAsyncTask extends AsyncTask<ForecastLocation, Void, Void> {
//        private SavedLocationsDao mAsyncTaskDAO;
//        DeleteAsyncTask(SavedLocationsDao dao) {
//            mAsyncTaskDAO = dao;
//        }
//
//        @Override
//        protected Void doInBackground(ForecastLocation... locations) {
//            mAsyncTaskDAO.delete(locations[0]);
//            return null;
//        }
//    }
}
