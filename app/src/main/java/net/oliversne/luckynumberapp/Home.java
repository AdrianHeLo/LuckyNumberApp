package net.oliversne.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Home extends AppCompatActivity {

    Button wishBtn;
    TextView user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wishBtn = findViewById(R.id.button);
        user = findViewById(R.id.uaserName);

        wishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user.getText().toString();
                //Intent Explicito
                Intent intent = new Intent(Home.this, LuckyNumber.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }

}