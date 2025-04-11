package com.example.lutemons;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.adapter.LutemonAdapter;
import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.Lutemon;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LutemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonAdapter(Storage.getInstance().getAllLutemons());
        recyclerView.setAdapter(adapter);
        Button btnBack = findViewById(R.id.buttonBackHome);
        btnBack.setOnClickListener(v -> finish());

    }
}
