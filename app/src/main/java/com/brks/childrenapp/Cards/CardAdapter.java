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

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Card> data;
    Context mContext;

    public CardAdapter(){}

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
         Card card = data.get(position);

         holder.cardName.setText(card.cardName);
         holder.cardDescription.setText(card.description);
         holder.cardLink.setText(card.link);
         holder.cardCost.setText(card.cost);
    }

    public CardAdapter(List<Card> data) {
        this.data = data;
    }

    public CardAdapter(Context context, List<Card> lstCard) {
        mContext = context;
        data = lstCard;
    }





    @Override
    public int getItemCount() {
        return data.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView cardName;
        private TextView cardDescription;
        private TextView cardLink;
        private TextView cardCost;

        public CardViewHolder(@NonNull View itemView){
            super(itemView);
            cardName = (TextView) itemView.findViewById(R.id.cardName);
            cardDescription = (TextView) itemView.findViewById(R.id.cardDescription);
            cardLink = (Button) itemView.findViewById(R.id.btnLink);
            cardCost = (TextView) itemView.findViewById(R.id.cardCost);

        }

    }

    public List<Card> getData() {
        return data;
    }

    public void setData(List<Card> data) {
        this.data = data;
    }

}
