package com.example.lutemons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnTrain, btnBattle, btnHome;
    // ImageViews for icons
    ImageView imgBattle, imgHome, imgTrain, imgCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind UI components to variables
        btnCreate=findViewById(R.id.CreateButton);
        btnTrain=findViewById(R.id.TrainButton);
        btnBattle=findViewById(R.id.BattleButton);
        btnHome=findViewById(R.id.HomeButton);
        imgCreate=findViewById(R.id.imageView2);
        imgBattle=findViewById(R.id.imageView4);
        imgHome=findViewById(R.id.imageView5);
        imgTrain=findViewById(R.id.imageView3);
        // Navigate to each respective activity
        btnCreate.setOnClickListener(v -> startActivity(new Intent(this, CreateLutemonActivity.class)));
        btnHome.setOnClickListener(v -> startActivity(new Intent(this, HomeActivity.class)));
        btnTrain.setOnClickListener(v -> startActivity(new Intent(this, TrainActivity.class)));
        btnBattle.setOnClickListener(v -> startActivity(new Intent(this, BattleActivity.class)));

    }
}