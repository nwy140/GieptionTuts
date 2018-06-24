package com.silentwolfstudios.user.realtimedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener{ // implement ValueEventListener reference

    private TextView tvTitle;
    private EditText etName;
    private Button btEnter;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //setup Firebasedatabase Structure
    private DatabaseReference rootReference = FirebaseDatabase.getReference(); // reference to root of database
    private DatabaseReference contentReference = rootReference.child("content"); // reference to child of root of database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tvTitle = findViewById(R.id.tvTitle);
         etName = findViewById(R.id.etName);
         btEnter = findViewById(R.id.btEnter);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
