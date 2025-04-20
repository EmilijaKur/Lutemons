package com.example.lutemons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutemons.logic.Battle;
import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.Lutemon;

public class BattleActivity extends AppCompatActivity {

    private TextView name1, name2, hp1, hp2, battleLog;
    private ImageView image1, image2;
    private FrameLayout bg1, bg2;
    private Button btnStart, btnBack;

    private Lutemon lutemon1, lutemon2;
    private Battle battle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);


        name1 = findViewById(R.id.nameLutemon1);
        name2 = findViewById(R.id.nameLutemon2);
        hp1 = findViewById(R.id.hpLutemon1);
        hp2 = findViewById(R.id.hpLutemon2);
        battleLog = findViewById(R.id.battleLog);
        image1 = findViewById(R.id.imageLutemon1);
        image2 = findViewById(R.id.imageLutemon2);
        bg1 = findViewById(R.id.bgLutemon1);
        bg2 = findViewById(R.id.bgLutemon2);
        btnStart = findViewById(R.id.btnAttack);
        btnBack = findViewById(R.id.btnBack);


        String lutemon1Name = getIntent().getStringExtra("lutemon1_name");
        String lutemon2Name = getIntent().getStringExtra("lutemon2_name");


        lutemon1 = findLutemonByName(lutemon1Name);
        lutemon2 = findLutemonByName(lutemon2Name);

        if (lutemon1 != null && lutemon2 != null) {
            // Set name and stats
            name1.setText(lutemon1.getName());
            name2.setText(lutemon2.getName());
            hp1.setText("HP: " + lutemon1.getHealth() + "/" + lutemon1.getMaxHealth());
            hp2.setText("HP: " + lutemon2.getHealth() + "/" + lutemon2.getMaxHealth());

            image1.setImageResource(R.drawable.lutemon);
            image2.setImageResource(R.drawable.lutemon);
            bg1.setBackgroundResource(getFrameResource(lutemon1.getColor()));
            bg2.setBackgroundResource(getFrameResource(lutemon2.getColor()));

            battle = new Battle(lutemon1, lutemon2);
            battleLog.setText("Battle between " + lutemon1.getColor() + " (" + lutemon1.getName() + ") and "
                    + lutemon2.getColor() + " (" + lutemon2.getName() + ") begins!\n");

            btnStart.setOnClickListener(v -> {
                String result = battle.executeTurn();
                battleLog.append(result);
                int hp1Current = Math.max(0, lutemon1.getHealth());
                int hp2Current = Math.max(0, lutemon2.getHealth());
                hp1.setText("HP: " + hp1Current + "/" + lutemon1.getMaxHealth());
                hp2.setText("HP: " + hp2Current + "/" + lutemon2.getMaxHealth());
                if (!battle.isBattleOngoing()) {
                    btnStart.setEnabled(false);
                }
            });
        }
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(BattleActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

    private Lutemon findLutemonByName(String name) {
        for (Lutemon l : Storage.getInstance().getAllLutemons()) {
            if (l.getName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    private int getFrameResource(String color) {
        switch (color.toLowerCase()) {
            case "white": return R.drawable.lutemon_frame_white;
            case "green": return R.drawable.lutemon_frame_green;
            case "pink": return R.drawable.lutemon_frame_pink;
            case "orange": return R.drawable.lutemon_frame_orange;
            case "black": return R.drawable.lutemon_frame_black;
            default: return R.drawable.lutemon_frame_white;
        }
    }
}
