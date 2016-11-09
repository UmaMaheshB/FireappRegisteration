package com.example.mahesh.fireappregisteration;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText editText1,editText2;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        dialog=new ProgressDialog(this);

    }

    public void submit(View view) {
        dialog.setMessage("Registering..");
        dialog.show();
        mAuth.createUserWithEmailAndPassword(editText1.getText().toString(),editText2.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete())
                        {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(),"Sucessfully registered",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
