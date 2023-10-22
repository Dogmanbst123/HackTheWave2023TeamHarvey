package com.example.hackthewave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class diagnosis extends AppCompatActivity {
    LinearLayout list;
    SearchView search;
    String searchValue;
    String[][] symptoms;
    ArrayList<String> diseases = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        list = findViewById(R.id.list);

        search = findViewById(R.id.symptomsearchview);
        /*search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.removeAllViews();
            }
        });*/
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list.removeAllViews();

                searchValue = search.getQuery().toString();

                String[][] temp = {{"Smallpox", "fever", "headache", "abdominal pain", "backache", "diarrhea"}, {"Scurvy", "weakness", "swelling", "bruising easily", "skin discoloration", "Anaemia"},{"Cancer", "fatigue", "inconsistent bladder", "coughing", "skin discoloration", "difficulty swallowing", "indigestion", "runny nose"}, {"Ebola", "fever", "aches", "weakness", "fatique", "sore throat", "vomiting", "diarrhea"}, {"Leprosy", "skin discoloration", "nodules", "dry skin", "swelling", "feet pain", "hair loss"}, {"COPD", "shortness of breath", "wheezing", "chronic cough", "lack of energy", "swelling", "weight loss"}, {"Tuberculosis", "runny nose", "weight loss", "fever", "swelling", "loss of appetite", "fatigue"}, {"Strep Throat", "fever", "sore throat", "swelling", "red spots in mouth"}, {"Whooping Cough", "runny nose", "coughing"}, {"Legionnaires", "fever", "loss of appetite", "headache", "diarrhea", "lethargy"}, {"Bubonic Plague", "fever", "headache", "weakness", "swelling"}, {"Spanish Flu", "runny nose", "coughing", "fever", "chills", "loss of appetite", "fatigue"}, {"Chicken Pox", "coughing", "headache", "sore throat", "difficutly breathing", "fever", "fatigue"}};
                diseases.clear();
                for(int j=0; j<temp.length; j++) {
                    for(int k=0; k<temp[j].length; k++) {
                        if(temp[j][k].equals(searchValue)){
                            diseases.add(temp[j][0]);
                        }
                    }
                }

                for(int i=0; i<diseases.size();i++) {
                    View searchv = getLayoutInflater().inflate(R.layout.diseases, null, false);
                    TextView st = searchv.findViewById(R.id.symptomview);
                    st.setText(diseases.get(i));
                    LinearLayout svl = searchv.findViewById(R.id.entireText);
                    svl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openDisease(st.getText().toString());
                        }
                    });
                    list.addView(searchv);
                }
                if(diseases.size()<1) {
                    View v = getLayoutInflater().inflate(R.layout.couldnotfind, null, false);
                    list.addView(v);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void openDisease(String sv) {
        Intent I = new Intent(this, chosenDisease.class);
        I.putExtra("Key", sv);
        startActivity(I);
    }
}