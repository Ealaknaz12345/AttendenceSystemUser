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
import com.techsam.attendencesystemuser.models.Batch;

public class registerbatch extends AppCompatActivity {

    EditText sbatch,semster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbatch);
        sbatch=findViewById(R.id.addbatch);
        semster=findViewById(R.id.addsemster);
    }

    public void submit(View view) {

        String name= sbatch.getText().toString();
        String num= semster.getText().toString();

        Batch batch =new Batch();
        batch.setBid(name);

        DatabaseReference db;
        db = FirebaseDatabase.getInstance().getReference();
        db.child("Batches").push().setValue(batch).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                sbatch.setText("");
                semster.setText("");
                Toast.makeText(registerbatch.this,"Data submitted",Toast.LENGTH_SHORT).show();
            }
        });




    }
}