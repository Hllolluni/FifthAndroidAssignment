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

public class MainActivity4 extends AppCompatActivity {

    TextView textView;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        this.textView = findViewById(R.id.textView5);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("traditional food");
        reference.setValue("The best known of all and most distinctive one, " +
                "flija, is prepared year-round but is a summer favourite. " +
                "Flija made with saç is a specialty from the traditional Albanian cuisine, " +
                "that is mostly prepared in mountainous areas. " +
                "It is most certainly one of the typical Kosovar dishes that everyone local will recommend. " +
                "Baklava is one of the traditional pastries of the Kosovar cuisine, although of Turkish origin." +
                " Bakllasarem is also a traditional food of Kosovo it is a salty pie with yoghurt and garlic covering."
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