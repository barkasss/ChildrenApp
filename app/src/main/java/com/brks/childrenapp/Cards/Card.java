package com.brks.childrenapp.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {

    String cardName;
    String description;
    String link;
    String cost;
    Button LinkBtn;

    public String getCardName() {
        return cardName;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getCost() {
        return cost;
    }
}






