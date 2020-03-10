package com.example.android.sqliteweather;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.sqliteweather.data.ForecastLocation;

import java.util.List;

public class SavedLocationsActivity extends AppCompatActivity implements SavedLocationAdapter.OnLocationClickListener {

    private SavedLocationsViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_locations);

        RecyclerView savedReposRV = findViewById(R.id.rv_saved_locations);
        savedReposRV.setLayoutManager(new LinearLayoutManager(this));
        savedReposRV.setHasFixedSize(true);

        final SavedLocationAdapter adapter = new SavedLocationAdapter(this);
        savedReposRV.setAdapter(adapter);

        mViewModel = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())
            ).get(SavedLocationsViewModel.class);

        mViewModel.getAllLocations().observe(this, new Observer<List<ForecastLocation>>() {
            @Override
            public void onChanged(List<ForecastLocation> savedLocations) {
                adapter.updateSavedLocations(savedLocations);
            }
        });
    }

    @Override
    public void onLocationClicked(ForecastLocation repo) {

    }
}
