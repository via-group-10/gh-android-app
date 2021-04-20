package com.example.grinhouseapp.ui.notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.grinhouseapp.R;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //return to home activity
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<NotificationItem> itemsList = new ArrayList<>();
        itemsList.add(new NotificationItem(R.drawable.ic_home_black_24dp,"1.1.420","16:00","17C","Greenhouse seems to be working"));
        itemsList.add(new NotificationItem(R.drawable.ic_thermostat,"1.1.420","16:00","17C","Greenhouse seems to be working"));

        itemsList.add(new NotificationItem(R.drawable.shape,"1.1.420","16:00","17C","Greenhouse seems to be working"));

        itemsList.add(new NotificationItem(R.drawable.ic_home_black_24dp,"1.1.420","16:00","17C","Greenhouse seems to be working"));

        itemsList.add(new NotificationItem(R.drawable.ic_home_black_24dp,"1.1.420","16:00","17C","Greenhouse seems to be working"));

        recyclerView = findViewById(R.id.notificationRecView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NotificationAdapter(itemsList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.menu.up_nav){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}