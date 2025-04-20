package com.example.lutemons;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.*;
/**
 * Activity for creating a new Lutemon and adding it to Storage.
 */

public class CreateLutemonActivity extends AppCompatActivity {
    EditText enterName;
    RadioGroup colorGroup;
    Button btnCreate, btnBack;
    ImageView imgLutemon;
    FrameLayout frameLutemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        // Initialize UI components
        enterName = findViewById(R.id.enterName);
        colorGroup = findViewById(R.id.colorGroup);
        btnCreate = findViewById(R.id.CreationButton);
        btnBack = findViewById(R.id.BackButton);
        imgLutemon = findViewById(R.id.Lutemon);
        frameLutemon = findViewById(R.id.bgLutemon);
        imgLutemon.setImageResource(R.drawable.lutemon);// default Lutemon image
        // Preview color frame when a color is selected
        colorGroup.setOnCheckedChangeListener((group, checkedId) -> {
            updateLutemonPreview(checkedId);
        });
        // Create Lutemon on button click
        btnCreate.setOnClickListener(view -> {
            String name = enterName.getText().toString();
            int selectedId = colorGroup.getCheckedRadioButtonId();
            if (name.isEmpty() || selectedId == -1) {
                Toast.makeText(this, "Please enter a name and select a color", Toast.LENGTH_SHORT).show();
            }
            // Get selected color text
            RadioButton selectedColor = findViewById(selectedId);
            Lutemon lutemon = null;
            String color = selectedColor.getText().toString();
            // Create corresponding Lutemon object
            if (selectedId == R.id.whiteRdBtn) {
                lutemon = new White(name);
            } else if (selectedId == R.id.greenRdBtn) {
                lutemon = new Green(name);
            } else if (selectedId == R.id.pinkRdBtn) {
                lutemon = new Pink(name);
            } else if (selectedId == R.id.orangeRdBtn) {
                lutemon = new Orange(name);
            } else if (selectedId == R.id.blackRdBtn) {
                lutemon = new Black(name);
            }
            // Store created Lutemon and navigate home
            if (lutemon != null) {
                Storage.getInstance().addLutemon(lutemon);
                Toast.makeText(CreateLutemonActivity.this, "Lutemon created!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateLutemonActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        btnBack.setOnClickListener(v -> finish());//closes the activity and goes to previous one

    }
    /**
     * Updates the background frame preview based on selected Lutemon color.
     */
    private void updateLutemonPreview(int checkedId) {
        int frameResource = R.drawable.lutemon_frame_white; // default

        if (checkedId == R.id.whiteRdBtn) {
            frameResource = R.drawable.lutemon_frame_white;
        } else if (checkedId == R.id.greenRdBtn) {
            frameResource = R.drawable.lutemon_frame_green;
        } else if (checkedId == R.id.pinkRdBtn) {
            frameResource = R.drawable.lutemon_frame_pink;
        } else if (checkedId == R.id.orangeRdBtn) {
            frameResource = R.drawable.lutemon_frame_orange;
        } else if (checkedId == R.id.blackRdBtn) {
            frameResource = R.drawable.lutemon_frame_black;
        }

        frameLutemon.setBackgroundResource(frameResource);
    }

}
