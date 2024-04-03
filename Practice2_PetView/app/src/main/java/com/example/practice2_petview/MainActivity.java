package com.example.practice2_petview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2;
    Button choose;
    CheckBox show;
    RadioGroup pets;
    RadioButton dog,cat,rabbit;
    ImageView imgPet;

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

        txt1 = (TextView) findViewById(R.id.text1);
        show = (CheckBox) findViewById(R.id.checkBox);

        txt2 = (TextView) findViewById(R.id.text2);
        pets = (RadioGroup) findViewById(R.id.rGroupt1);
        dog = (RadioButton) findViewById(R.id.rBtn1);
        cat = (RadioButton) findViewById(R.id.rBtn2);
        rabbit = (RadioButton) findViewById(R.id.rBtn3);

        choose = (Button) findViewById(R.id.ok);
        imgPet = (ImageView) findViewById(R.id.petImage);

        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(show.isChecked()){
                    txt2.setVisibility(View.VISIBLE);
                    pets.setVisibility(View.VISIBLE);
                    choose.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else{
                    txt2.setVisibility(View.INVISIBLE);
                    pets.setVisibility(View.INVISIBLE);
                    choose.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = pets.getCheckedRadioButtonId();
                if(selectedId==-1)return;
                if(selectedId == R.id.rBtn1) {
                    imgPet.setImageResource(R.drawable.sampledog);
                }
                else if(selectedId == R.id.rBtn2) {
                    imgPet.setImageResource(R.drawable.samplecat);
                }
                else if(selectedId == R.id.rBtn3){
                        imgPet.setImageResource(R.drawable.samplerabbit);
                }
            }
        });
    }
}