package com.example.lutemons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.adapter.HomeLutemonAdapter;
import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.Lutemon;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeLutemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Initialize and populate RecyclerView with home Lutemons
        recyclerView = findViewById(R.id.recyclerLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeLutemonAdapter(this, Storage.getInstance().getLutemonsByLocation("home"));
        recyclerView.setAdapter(adapter);
        //Back button to previous screen
        Button btnBack = findViewById(R.id.buttonBackHome);
        btnBack.setOnClickListener(v -> finish());
        // Button to start battle if exactly 2 Lutemons are in the battle area
        Button btnStartBattle = findViewById(R.id.btnStartBattle);
        btnStartBattle.setOnClickListener(v -> {
            ArrayList<Lutemon> battleLutemons = Storage.getInstance().getLutemonsByLocation("battle");
            if (battleLutemons.size() == 2) {
                // Send selected Lutemons' names to BattleActivity
                Intent intent = new Intent(this, BattleActivity.class);
                intent.putExtra("lutemon1_name", battleLutemons.get(0).getName());
                intent.putExtra("lutemon2_name", battleLutemons.get(1).getName());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Move exactly 2 Lutemons to battle arena first!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
