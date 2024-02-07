package com.example.miniprojetlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityBytton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytton);
        Button btn1 = findViewById(R.id.home_entry);
        Button btn2 = findViewById(R.id.work_entry);
        Button btn3 = findViewById(R.id.personal_entry);
        TextView home_item = findViewById(R.id.home_item);
        TextView work_item = findViewById(R.id.work_item);
        TextView personel_item = findViewById(R.id.personnel_item);

        home_item.setText(Home.listHome.size()+" items");
        personel_item.setText(PersonalActivity.listPer.size()+" items");
        work_item.setText(Work.listWork.size()+" items");
        btn1.setOnClickListener((View)->{
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
        });
        btn2.setOnClickListener((View)->{
            Intent intent = new Intent(this,Work.class);
            startActivity(intent);
        });
        btn3.setOnClickListener((View)->{
            Intent intent = new Intent(this,PersonalActivity.class);
            startActivity(intent);
        });
    }
}