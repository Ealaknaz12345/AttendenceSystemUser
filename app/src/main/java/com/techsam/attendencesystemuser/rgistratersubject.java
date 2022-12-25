package com.techsam.attendencesystemuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techsam.attendencesystemuser.models.Subject;

public class rgistratersubject extends AppCompatActivity {
    EditText subname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgistratersubject);
        subname = findViewById(R.id.subname);

    }



    public void submit(View view) {
        String name= subname.getText().toString();


        Subject subject= new Subject();
        subject.setSubName(name);

        DatabaseReference db;
        db= FirebaseDatabase.getInstance().getReference();
        db.child("Subjects").push().setValue(subject).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                subname.setText("");
                Toast.makeText(rgistratersubject.this,"Data submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }

}