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

public class MainActivity3 extends AppCompatActivity {

    TextView textView;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.textView = findViewById(R.id.textView6);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("museums");
        reference.setValue("- National Museum of Kosovo has a collection of more than 50 thousand exhibits of different profiles, " +
                        "from archaeology, technology, history, nature, entoculture, folklore, " +
                        "heritage and almost everything that shows the history of Kosovo in different times, " +
                        "from the Neolithic era, 6 thousand years BC, until today. " +
                        "The Kosovo Museum has an extensive collection of archaeological and ethnological artifacts, " +
                        "including the Neolithic Goddess on the Throne terracotta, found near Pristina in and depicted in the city's emblem. " +
                        "A large number of artifacts from antiquity are still in Belgrade, and the museum was looted in 1999.\n\n" +
                        "- The Ethnological Museum Emin Gjiku is an integral part of the National Museum of Kosovo in Prishtina, " +
                        "located in the old housing complex, consisting of four buildings, two of which date from the eighteenth century " +
                        "and two others from the nineteenth century. The concept of the Ethnological Museum is based on four topics which" +
                        "represent the life cycle including birth, life, death and spiritual heritage. " +
                        "The Stone House is also a part of the museum which today serves as a center of contemporary art – station.");

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