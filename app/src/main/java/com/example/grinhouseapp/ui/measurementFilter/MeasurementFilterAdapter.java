package com.example.grinhouseapp.ui.measurementFilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;

import java.util.ArrayList;

public class MeasurementFilterAdapter extends RecyclerView.Adapter<MeasurementFilterAdapter.NewFilterViewHolder> {

    private ArrayList<Measurement> measurementsList;

    static class NewFilterViewHolder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView hour;
        public TextView value;
//        public ImageView image;


        public NewFilterViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.filter_date);
            hour = itemView.findViewById(R.id.filter_hour);
            value = itemView.findViewById(R.id.filter_value);
//            image = itemView.findViewById(R.id.filter_image);
        }
    }

    public MeasurementFilterAdapter(ArrayList<Measurement> list ){
        this.measurementsList = list;
    }

    @NonNull
    @Override
    public NewFilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filtered_item,parent,false);
        NewFilterViewHolder evh = new NewFilterViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewFilterViewHolder holder, int position) {
        Measurement currentItem = measurementsList.get(position);
        holder.hour.setText(String.valueOf(currentItem.getMeasurementDateTime()) );
        holder.date.setText(String.valueOf(currentItem.getMeasurementDateTime()));
        holder.value.setText( String.valueOf(currentItem.getMeasurementValue()));
    }

    @Override
    public int getItemCount() {
        return measurementsList.size();
    }




}
