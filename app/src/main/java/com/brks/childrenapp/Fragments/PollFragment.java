package com.brks.childrenapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brks.childrenapp.Activities.PollActivity;
import com.brks.childrenapp.R;


public class PollFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String name = "Опрос";
    private static final String quizDescription = "В данном опросе нет правильных или неправильных ответов. Отвечайте так, как считаете нужным.";
    private Button btnNext;

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PollFragment() {
        // Required empty public constructor
    }

    public static PollFragment newInstance(String param1, String param2) {
        PollFragment fragment = new PollFragment();
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
        View v = inflater.inflate(R.layout.fragment_poll, container, false);

        btnNext = v.findViewById(R.id.btnNextQuiz);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PollActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }


    }
