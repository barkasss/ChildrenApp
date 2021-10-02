package com.brks.childrenapp.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {

    String cardName;
    String description;
    String key;
    String link;
    String cost;

    public Card(){}

    public Card(String cardName, String description, String key, String link, String cost){
        this.cardName = cardName;
        this.description = description;
        this.key = key;
        this.link = link;
        this.cost = cost;
    }

    //Getters


    public String getCardName() {
        return cardName;
    }
    public String getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }


    public String getLink() {
        return link;
    }

    // Setters


    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("cardName",cardName);
        result.put("Description", description);
        result.put("link",link);
        result.put("key",key);
        result.put("cost",cost);

        return result;
    }

}






