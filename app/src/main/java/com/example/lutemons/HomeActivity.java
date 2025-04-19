package com.example.lutemons;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.adapter.HomeLutemonAdapter;
import com.example.lutemons.logic.Storage;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeLutemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeLutemonAdapter(this, Storage.getInstance().getLutemonsByLocation("home"));
        recyclerView.setAdapter(adapter);
        Button btnBack = findViewById(R.id.buttonBackHome);
        btnBack.setOnClickListener(v -> finish());

    }
}
