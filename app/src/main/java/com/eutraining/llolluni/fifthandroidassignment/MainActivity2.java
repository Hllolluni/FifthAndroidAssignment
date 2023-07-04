package com.eutraining.llolluni.fifthandroidassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.textView = findViewById(R.id.textView7);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("overview");
        reference.setValue(
                "Tourism in Pristina attracted 36,186 foreign visitors in 2012, which represents 74.2%" +
                " of all visitors that visited Kosovo during that year. Foreign visitors mostly come from countries like Albania," +
                " Turkey, Germany, United States, Slovenia and North Macedonia," +
                " but also from other countries. Some of the most visited places in Pristina are " +
                "Batlava Lake and Gadime Marble Cave, which are also among the most visited places in Kosovo.\n\n" +
                "Pristina is the first touristic destination in Kosovo and the main air gateway to Kosovo. " +
                "The number of foreign visitors that have visited Prishtina during 2012 grew by more than 10 " +
                "thousand visitors since 2008, when there were 25,434 visitors." +
                " During the first quarter of 2013 the number of hotels in Prishtina was 24 from 102 hotels that were in total" +
                " in Kosovo and during the third quarter of the year 2013, 18.85% of hotel capacity were used and " +
                "during the same period of that year, in Prishtina 423 rooms were with one bed, 268 rooms with two beds," +
                " 13 rooms with three beds, 49 apartments and 6 residents."
        );
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textView.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}