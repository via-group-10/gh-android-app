package com.example.grinhouseapp.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private ArrayList<ProfileItem> profileList;
    public static class ProfileViewHolder extends RecyclerView.ViewHolder{

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
    }

    public ProfileAdapter(ArrayList<ProfileItem> profileLst){ profileList = profileLst;}

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item,parent,false);
       ProfileViewHolder evh = new ProfileViewHolder(v);
       return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ProfileItem currentItem = profileList.get(position);

        holder.profileName.setText(currentItem.getProfileName());

        //converting float to string since setText can't take float
        String co2 = String.valueOf(currentItem.getValueCO2());
        holder.carbonValue.setText(co2 + "ppm");

        String hum = String.valueOf(currentItem.getValueHumidity());
        holder.humidityValue.setText(hum+"%");

        String temp = String.valueOf(currentItem.getValueTemperature());
        holder.temperatureValue.setText(temp+"°C");


    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


}
