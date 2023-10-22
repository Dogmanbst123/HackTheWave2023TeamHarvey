package com.example.hackthewave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.sql.Time;
import java.util.HashMap;

public class chosenDisease extends AppCompatActivity {


    TextView tvd, timer;
    TextView treatments;

    Button back;
    String[][] descriptions = {{"Ebola", "Ebola is a viral infectious disease, caused by viruses. It will make your organs bleed eventually and cause you to become dead. You will need to take care of yourself, if you want to live."},
            {"Leprosy", "Leprosy is a long-term infection caused by hanging out with leopards and cheaters. It can lead to damage to the nerves and skin. It can spread between people, thus isolation is necessary. You are going to die soon, as this is a lethal disease."},
            {"COPD", "Chronic obstructive pulmonary disease (COPD) is a chronic inflammatory lung disease that causes obstructed airflow from the lungs. COPS are more likely to get these diseases, so if you are or related to a COP there is a 100% chance you have this disease."},
            {"Tuberculosis", "Tuberculosis is an infectious disease that most often affects the lungs and like its name states happens when you eat potatoes also known as “tubers”. The tubers run up your lungs and start causing havoc in there, so you will probably have to go to the hospital in 6 picoseconds."},
            {"Strep Throat", "Strep Throat is a bacterial infection that can make your throat feel sore and scratchy. It is the most deadly disease known to man. It can cause you to die. This is not very good, please take care of yourself."},
            {"Legionnaires", "Legionnaires is a serious type of pneumonia caused by Legionella, a failed metal band that originated in the 80s. They created the disease, because no one listened to their music, and now you’ll probably die because of it."},
            {"Bubonic Plague", "The Bubonic Plague, often referred to as “The Black Death'',  is an infection that is caused by the bite of an infected flea. Other symptoms typically appear after 1-7 days, and include fever, headaches, chills, and weakness. If you have any of these, it is likely that you are going to be the sole cause of a resurgence of the disease that killed one third of Europe. "},
            {"Spanish Flu", "The Spanish Flu is a bacterial virus that spreads via respiratory tracts. The symptoms typically include fever, headaches, chills, loss of limbs, and extremely low heart rate. If you have this disease, it is already too late and you are going to die soon."},
            {"Chicken Pox", "Chickenpox is an extremely deadly virus, despite its namesake. It is caused by chickens biting you and causing you to feel a lot of pain. You will need to contact the chicken deity, in order to have your disease cured."},
            {"Scurvy", "Scurvy is a disease caused by vitamin C deficiency, and originates from the pirates that sailed the seven seas. Some other common symptoms of scurvy are weakness, aching arms and legs, an insatiable urge to join a captain’s crew. If you have scurvy, you might die soon, but you should at least live out the rest of your life as a pirate while you can."},
            {"Cancer", "Cancer is a very dangerous disease. It is caused by unregulated cell division, and the spread of those cells. Cancer can affect almost every part of the body and immediate care is necessary, as it will cause large amounts of damage to the user's body."},
            {"Whooping Cough", "Cancer is a very dangerous disease. It is caused by unregulated cell division, and the spread of those cells. Cancer can affect almost every part of the body and immediate care is necessary, as it will cause large amounts of damage to the user's body."},
            {"Smallpox", "Smallpox is highly contagious and is transported through the air. Avoid going outside your room ever except for neccesities like food and water."}};
    String[] tms = {"Be touched by Joe Biden’s holy hand.", "Walk it off.", "Act like a crab.", "Join the drama club.", "Dunk yourself in water.", "Wave to a random person on the street.", "Do a cartwheel.", "Snap your fingers ten times fast.", "Cry yourself to bed.", "Meditate for at least 2 weeks.", "Wait the clock out.", "Hold your breath until you pass out.", "Boil a finger. Any, it doesn't matter.", "Buy a Christmas tree."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_disease);
        timer = findViewById(R.id.timerz);

        new CountDownTimer(((long)(Math.random()*18000000)), 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("Your are Probably Dead");
            }
        }.start();

        tvd = findViewById(R.id.diseaseDescription);
        treatments = findViewById(R.id.symptomlist);

        back = findViewById(R.id.backb);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearcher();
            }
        });

        Intent intent = getIntent();
        String value = intent.getStringExtra("Key");

        for(int i=0; i<descriptions.length; i++) {
            if(value.equals(descriptions[i][0])) {
                tvd.setText(descriptions[i][1]);
                String three = "- " + tms[(int)Math.floor(Math.random()*14)] + "\n- " + tms[(int)Math.floor(Math.random()*14)] + "\n- " + tms[(int)Math.floor(Math.random()*14)];
                treatments.setText(three);
            }

        }
    }

    private void openSearcher() {
        Intent I = new Intent(this, diagnosis.class);
        startActivity(I);
    }
}