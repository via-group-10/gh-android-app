package com.example.grinhouseapp.ui.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    private ArrayList<NotificationItem> notificationList;
    public static class NotificationViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView date;
    public TextView hour;
    public TextView value;
    public TextView description;

        public NotificationViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView  = itemView.findViewById(R.id.notification_icon);
            date = itemView.findViewById(R.id.notification_date);
            hour = itemView.findViewById(R.id.notification_time);
            value = itemView.findViewById(R.id.notification_value);
            description = itemView.findViewById(R.id.notification_desc);

        }
    }

    public NotificationAdapter(ArrayList<NotificationItem> itemLst){
        notificationList = itemLst;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
       NotificationViewHolder evh = new NotificationViewHolder(v);
       return evh;
    }



    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationItem currentItem = notificationList.get(position);

        holder.imageView.setImageResource(currentItem.getnImageResource());
        holder.date.setText(currentItem.getnDate());
        holder.hour.setText(currentItem.getnHour());
        holder.value.setText(currentItem.getnValue());
        holder.description.setText(currentItem.getnDescription());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}
