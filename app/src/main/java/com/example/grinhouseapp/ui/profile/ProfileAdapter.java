package com.example.grinhouseapp.ui.profile;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.ui.editProfile.EditProfileViewModel;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private ArrayList<ThresholdProfile> profileList;
    final private OnListItemClickListener listener;
    public static Boolean ifActivate;

    class ProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView profileName;
        public TextView carbonValue;
        public TextView humidityValue;
        public TextView temperatureValue;
        public Button editBtn;
        public Button removeBtn;
        public CardView profileItem;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.profile_name);
            carbonValue = itemView.findViewById(R.id.measurement_carbon);
            humidityValue = itemView.findViewById(R.id.measurement_humidity);
            temperatureValue = itemView.findViewById(R.id.measurement_temperature);
            editBtn = itemView.findViewById(R.id.EditBtn);
            removeBtn = itemView.findViewById(R.id.RemoveBtn);
            profileItem = itemView.findViewById(R.id.profileItem);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
            listener.deleteProfile(profileList.get(getAdapterPosition()).getThresholdProfileId(),getAdapterPosition());
            listener.updateProfile(getAdapterPosition());
           // switch (v.getId())
           // {
           //     case R.id.RemoveBtn:
           //     break;
           // }
        }
    }

    public ProfileAdapter(ArrayList<ThresholdProfile> profileLst, OnListItemClickListener listener)
    {
        this.profileList = profileLst;
        this.listener = listener;
        ifActivate = true;
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
       holder.removeBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              //profileList.remove(position);
              //notifyItemRemoved(position);
              //notifyItemRangeChanged(position,getItemCount());
              //notifyDataSetChanged();
               ifActivate = false;
               listener.deleteProfile(profileList.get(position).getThresholdProfileId(),position);
           }
       });
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifActivate = false;
                EditProfileViewModel.OldProfile = profileList.get(position);
                listener.updateProfile(position);
                //Navigation.findNavController(v).navigate(R.id.navigateToUpdateProfilesFragment);
            }
        });
        holder.profileItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifActivate=true) {
                    listener.onListItemClick(position);
                }
            }
        });

        if (currentItem.isActive()) {
            holder.profileItem.setCardBackgroundColor(Color.parseColor("#FF03DAC5"));
        }
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
        void deleteProfile(int id,int position);
        void updateProfile(int position);
    }

}
