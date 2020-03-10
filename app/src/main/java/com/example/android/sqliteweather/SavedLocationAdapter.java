package com.example.android.sqliteweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.sqliteweather.data.ForecastLocation;

import org.w3c.dom.Text;

import java.util.List;

public class SavedLocationAdapter extends RecyclerView.Adapter<SavedLocationAdapter.SavedLocationsViewHolder> {
    private List<ForecastLocation> mLocationsList;
    private OnLocationClickListener mLocationClickListener;

    interface OnLocationClickListener {
        void onLocationClicked(ForecastLocation location);
    }

    public SavedLocationAdapter(OnLocationClickListener listener) {
        mLocationClickListener = listener;
    }

    public void updateSavedLocations(List<ForecastLocation> locationsList) {
        mLocationsList = locationsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mLocationsList != null) {
            return mLocationsList.size();
        } else {
            return 0;
        }
    }

    @NonNull
    @Override
    public SavedLocationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.saved_location_item, parent, false);
        return new SavedLocationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SavedLocationsViewHolder holder, int position) {
        holder.bind(mLocationsList.get(position));
    }

    class SavedLocationsViewHolder extends RecyclerView.ViewHolder {
        private TextView mSavedLocationTV;

        SavedLocationsViewHolder(View itemView) {
            super(itemView);
            mSavedLocationTV = itemView.findViewById(R.id.tv_saved_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLocationClickListener.onLocationClicked(
                            mLocationsList.get(getAdapterPosition())
                    );
                }
            });
        }

        void bind(ForecastLocation location) {
            mSavedLocationTV.setText(location.location);
        }
    }
}
