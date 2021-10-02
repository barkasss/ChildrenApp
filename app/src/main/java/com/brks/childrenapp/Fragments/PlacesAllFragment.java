package com.brks.childrenapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brks.childrenapp.Cards.Card;
import com.brks.childrenapp.Cards.CardAdapter;
import com.brks.childrenapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class PlacesAllFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Card> lstCard = new ArrayList<>();
    private CardAdapter recyclerAdapter;

    private DatabaseReference database;
    private FirebaseAuth mAuth;


    public PlacesAllFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_places_all, container, false);
        lstCard.clear();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://childrenapp-4aba1-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("cards");
        FirebaseUser user = mAuth.getCurrentUser();

        recyclerView = v.findViewById(R.id.listAll);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new CardAdapter(getContext(),lstCard);
        recyclerView.setAdapter(recyclerAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstCard.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    Card card = ds.getValue(Card.class);
                    lstCard.add(card);

                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    return v;
    }





}
