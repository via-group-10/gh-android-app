package com.example.grinhouseapp.ui.filter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MeasurementFilterViewHolder> {

    private ArrayList<Measurement> measurementsList;

    class MeasurementFilterViewHolder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView hour;
        public TextView value;
        public LinearLayout card;
//        public ImageView image;


        public MeasurementFilterViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.filter_date);
            hour = itemView.findViewById(R.id.filter_hour);
            value = itemView.findViewById(R.id.filter_value);
//            image = itemView.findViewById(R.id.filter_image);
            card = itemView.findViewById(R.id.filter_item_container);
        }
    }

    public FilterAdapter(ArrayList<Measurement> list ){
        this.measurementsList = list;
    }

    @NonNull
    @Override
    public MeasurementFilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filtered_item,parent,false);
        MeasurementFilterViewHolder evh = new MeasurementFilterViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull MeasurementFilterViewHolder holder, int position) {
        Measurement currentItem = measurementsList.get(position);

        Date date = new Date();
        date.setTime(currentItem.getMeasurementDateTime().getTime());
        String hourString = new SimpleDateFormat("HH:mm").format(date);
        String dateString = new SimpleDateFormat("dd-MM-yyyy").format(date);
        holder.hour.setText(hourString);
        holder.date.setText(dateString);
        holder.value.setText( String.valueOf(currentItem.getMeasurementValue()));

        if (position % 2 == 0){
            holder.card.setBackgroundColor(Color.parseColor("#e6e6e6"));
        } else {
            holder.card.setBackgroundColor(Color.parseColor("#ffffff"));

        }
    }

    @Override
    public int getItemCount() {
        return measurementsList.size();
    }


}
