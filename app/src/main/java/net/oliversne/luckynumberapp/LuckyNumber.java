package net.oliversne.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumber extends AppCompatActivity {

    TextView luckyNumberDisplay;
    Button shareBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        luckyNumberDisplay = findViewById(R.id.luckyNumber);
        shareBtm = findViewById(R.id.button2);

        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("userName");

        String luckyNumber = String.valueOf(randomNumber());
        luckyNumberDisplay.setText(luckyNumber);

        shareBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(user,luckyNumber);
            }
        });

    }

    private int randomNumber(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    };

    private void shareData(String user, String number){
        //Intent Implicito

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        //Additional Info
        intent.putExtra(Intent.EXTRA_SUBJECT, user + " Got Lucky Today!!!");

        intent.putExtra(Intent.EXTRA_TEXT, "Your lucky number is: " + number);
        //Abre los metodos de compartir informacion o multimedia en Android
        startActivity(Intent.createChooser(intent,"Choose a Platform"));
    };

}