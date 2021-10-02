package com.brks.childrenapp.Cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.brks.childrenapp.R;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    ArrayList<Card> list;
    Context Context;

    public CardAdapter(Context context, ArrayList<Card> lstCard) {
        Context = context;
        list = lstCard;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Context).inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Card card = list.get(position);
        holder.cardName.setText(card.getCardName());
        holder.description.setText(card.getDescription());
        holder.cost.setText(card.getCost());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView cardName, description, cost;
        Button LinkBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardName = itemView.findViewById(R.id.cardName);
            description = itemView.findViewById(R.id.cardDescription);
            LinkBtn = itemView.findViewById(R.id.btnLink);
            cost = itemView.findViewById(R.id.cardCost);
        }
    }

}
