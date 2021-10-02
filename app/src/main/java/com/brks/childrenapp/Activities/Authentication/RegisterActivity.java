package com.brks.childrenapp.Activities.Authentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.brks.childrenapp.Activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.brks.childrenapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference database;

    private DatabaseReference emailParentRef;
    private DatabaseReference surnameRef;
    private DatabaseReference nameRef;
    private DatabaseReference cityRef;

    private EditText ETemail;
    private EditText ETemailParent;
    private EditText ETSurname;
    private EditText ETName;
    private EditText ETCity;
    private EditText ETpassword;
    private Button backBtn;
    private Button regBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backBtn = findViewById(R.id.btn_back);
        regBtn = findViewById(R.id.registration);
        ETemail = findViewById(R.id.email);
        ETemailParent = findViewById(R.id.email_parent);
        ETSurname = findViewById(R.id.surname);
        ETName = findViewById(R.id.name);
        ETCity = findViewById(R.id.city);
        ETpassword = findViewById(R.id.password);


        backBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        setTitle("Регистрация");
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            //Непосредственный вход в программу при условии успеха регистрации
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent intent = new Intent(getApplicationContext(), AutActivity.class);
                startActivity(intent);
                break;
            case R.id.registration:
                if (!ETemail.getText().toString().equals("") && !ETpassword.getText().toString().equals("")) {
                    registration(ETemail.getText().toString(), ETpassword.getText().toString());
                } else
                    Toast.makeText(getApplicationContext(), "Проверьте данные", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information


                            database = FirebaseDatabase.getInstance("https://childrenapp-4aba1-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("users");

                            FirebaseUser user = mAuth.getCurrentUser();

                            //Добавление личных данных пользователя
                            emailParentRef = database.child(user.getUid()).child("emailParent");
                            surnameRef = database.child(user.getUid()).child("surname");
                            nameRef = database.child(user.getUid()).child("name");
                            cityRef = database.child(user.getUid()).child("city");
                            emailParentRef.setValue(ETemailParent.getText().toString());
                            surnameRef.setValue(ETSurname.getText().toString());
                            nameRef.setValue(ETName.getText().toString());
                            cityRef.setValue(ETCity.getText().toString());


                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Авторизация не удалась.",
                                    Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


}