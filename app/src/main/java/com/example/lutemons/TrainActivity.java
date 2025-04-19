package com.example.lutemons;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.adapter.TrainingLutemonAdapter;
import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.*;

import java.util.ArrayList;

public class TrainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TrainingLutemonAdapter adapter;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        recyclerView = findViewById(R.id.recyclerTrainingLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Lutemon> trainingLutemons = Storage.getInstance().getLutemonsByLocation("training");
        adapter = new TrainingLutemonAdapter(this, trainingLutemons);
        recyclerView.setAdapter(adapter);

        btnBack = findViewById(R.id.buttonBackTraining);
        btnBack.setOnClickListener(v -> finish());
    }
}
