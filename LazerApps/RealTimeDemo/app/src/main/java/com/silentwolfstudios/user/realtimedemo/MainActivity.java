package com.silentwolfstudios.user.realtimedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //setup Firebasedatabase Structure //remember to setup your database in firebase first
    private DatabaseReference rootReference = firebaseDatabase.getReference(); // reference to root of database
    private DatabaseReference contentReference = rootReference.child("content"); // reference to child of root of database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tvTitle = findViewById(R.id.tvTitle);
         etName = findViewById(R.id.etName);
         btEnter = findViewById(R.id.btEnter);

         btEnter.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String content = etName.getText().toString();
                 contentReference.setValue(content); // get whatever in etName and send it to Firebase Database
             }
         });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key = dataSnapshot.getKey();
            if(key.equals("content")){
                String value = dataSnapshot.getValue(String.class); // get data from firebase
                tvTitle.setText(value);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    //LifeCycle methods // OnCreate // OnStart calls right after OnCreate// OnDestroy

    @Override
    protected void onStart() {
        super.onStart();
        contentReference.addValueEventListener(this); //setup this ValueListener on this interface


    }
}