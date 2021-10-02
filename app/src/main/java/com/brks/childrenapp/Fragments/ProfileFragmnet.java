package com.brks.childrenapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.brks.childrenapp.Activities.Authentication.AutActivity;
import com.brks.childrenapp.Activities.MainActivity;
import com.brks.childrenapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragmnet extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView TextViewName;
    private TextView TextViewSurname;
    private TextView TextViewCity;
    private TextView TextViewEmail;
    private Button BtnSignOut;

    private DatabaseReference database;
    private FirebaseAuth mAuth;

    private DatabaseReference emailParentRef;
    private DatabaseReference surnameRef;
    private DatabaseReference nameRef;
    private DatabaseReference cityRef;

    public ProfileFragmnet() {
        // Required empty public constructor
    }

    public static ProfileFragmnet newInstance(String param1, String param2) {
        ProfileFragmnet fragment = new ProfileFragmnet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_fragmnet, container, false);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://childrenapp-4aba1-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("users");
        FirebaseUser user = mAuth.getCurrentUser();

        emailParentRef = database.child(user.getUid()).child("emailParent");
        surnameRef = database.child(user.getUid()).child("surname");
        nameRef = database.child(user.getUid()).child("name");
        cityRef = database.child(user.getUid()).child("city");

        TextViewEmail = v.findViewById(R.id.profileEmail);
        TextViewName = v.findViewById(R.id.profileName);
        TextViewSurname = v.findViewById(R.id.profileSurname);
        TextViewCity = v.findViewById(R.id.profileCity);

        BtnSignOut = v.findViewById(R.id.btnSignOut);
        BtnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(getContext(), AutActivity.class);
                startActivity(intent);
            }
        });

        emailParentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextViewEmail.setText("Контакнт взрослого: " + snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        nameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextViewName.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        surnameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextViewSurname.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        cityRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextViewCity.setText("Ваш город: " + snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       // TextViewName.setText(myRef.);

        return v;
    }
}