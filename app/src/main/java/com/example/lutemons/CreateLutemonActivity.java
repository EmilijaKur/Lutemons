package com.example.lutemons;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.*;


public class CreateLutemonActivity extends AppCompatActivity {
    EditText enterName;
    RadioGroup colorGroup;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        enterName=findViewById(R.id.enterName);
        colorGroup=findViewById(R.id.colorGroup);
        btnCreate=findViewById(R.id.CreationButton);

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name=enterName.getText().toString();
                int selectedId=colorGroup.getCheckedRadioButtonId();
                RadioButton selectedColor=findViewById(selectedId);

                Lutemon lutemon=null;
                String color=selectedColor.getText().toString();

                switch (color.toLowerCase()){
                    case "white":
                        lutemon=new White(name);
                        break;
                    case "green":
                        lutemon=new Green(name);
                        break;
                    case "pink":
                        lutemon=new Pink(name);
                        break;
                    case "orange":
                        lutemon=new Orange(name);
                        break;
                    case "black":
                        lutemon=new Black(name);
                        break;

                }
                if(lutemon!=null){
                    Storage.getInstance().addLutemon(lutemon);
                    Toast.makeText(CreateLutemonActivity.this, "Lutemon created!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }


}
