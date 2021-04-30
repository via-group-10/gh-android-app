package com.example.grinhouseapp.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private ArrayList<ThresholdProfile> profileList;
    final private OnListItemClickListener listener;

    class ProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView profileName;
        public TextView carbonValue;
        public TextView humidityValue;
        public TextView temperatureValue;
        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.profile_name);
            carbonValue = itemView.findViewById(R.id.measurement_carbon);
            humidityValue = itemView.findViewById(R.id.measurement_humidity);
            temperatureValue = itemView.findViewById(R.id.measurement_temperature);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }
    }

    public ProfileAdapter(ArrayList<ThresholdProfile> profileLst, OnListItemClickListener listener)
    {
        this.profileList = profileLst;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item,parent,false);
       ProfileViewHolder evh = new ProfileViewHolder(v);
       return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ThresholdProfile currentItem = profileList.get(position);

        holder.profileName.setText(currentItem.getProfileName());

        holder.carbonValue.setText(currentItem.getMinimumCarbonDioxide() + "ppm - " + currentItem.getMaximumCarbonDioxide() + "ppm");
        holder.humidityValue.setText(currentItem.getMinimumHumidity() + "% - " + currentItem.getMaximumHumidity() + "%");
        holder.temperatureValue.setText(currentItem.getMinimumTemperature() + "℃ - " + currentItem.getMaximumTemperature() + "℃");


    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
