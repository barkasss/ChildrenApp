package com.brks.childrenapp.Answers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.brks.childrenapp.R;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

    private List<SingleAnswer> data;
    private boolean result;

    public AnswerAdapter(){
    }

    public AnswerAdapter(List<SingleAnswer> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView answer;
        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            answer = (TextView) itemView.findViewById(R.id.itemTextId);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkBox.isChecked()){

                        if (answer.equals("@string/answer_1.2"))
                            Statistic.Command = 1;
                        else if (answer.equals("@string/answer_1.2")){}

                        else if (answer.equals("@string/answer_1.3")) {}
                        else if (answer.equals("@string/answer_2.1"))
                            Statistic.VodniiSport+=2;
                        else if (answer.equals("@string/answer_2.2"))
                            Statistic.SportSMachom+=2;
                        else if (answer.equals("@string/answer_2.3"))
                            Statistic.SportSTech+=1;
                        else if (answer.equals("@string/answer_2.4"))
                            Statistic.Atletica+=2;
                        else if (answer.equals("@string/answer_2.5"))
                            Statistic.ZimniySport+=2;
                        else if (answer.equals("@string/answer_2.6"))
                            Statistic.SilovoySport+=2;
                        else if (answer.equals("@string/answer_3.1"))
                            Statistic.Tourism+=1;
                        else if (answer.equals("@string/answer_3.2"))
                            Statistic.Zrelische+=1;
                        else if (answer.equals("@string/answer_3.4"))
                            Statistic.Iscustvo+=1;
                        else if (answer.equals("@string/answer_3.5")) {
                            Statistic.EstNauk += 1;
                            Statistic.RazvivIGry+=1;
                        }
                        else if (answer.equals("@string/answer_3.6"))
                            Statistic.RazvivIGry+=1;
                        else if (answer.equals("@string/answer_3.7"))
                            Statistic.Music+=1;
                        else if (answer.equals("@string/answer_3.8")) {
                            Statistic.EstNauk+=1;
                            Statistic.GumNauki+=1;
                        }
                        else if (answer.equals("@string/answer_4.1"))
                            Statistic.Constructor+=1;
                        else if (answer.equals("@string/answer_4.2")) {
                            Statistic.Atletica+=1;
                            Statistic.VodniiSport+=1;
                            Statistic.ZimniySport+=1;
                            Statistic.SilovoySport+=1;
                            Statistic.SportSMachom+=1;
                            Statistic.SportSTech+=1;
                        }
                        else if (answer.equals("@string/answer_4.3")) {
                            Statistic.ZimniySport += 1;
                            Statistic.SportSTech +=1;
                        }
                        else if (answer.equals("@string/answer_4.4"))
                            Statistic.Music+=1;
                        else if (answer.equals("@string/answer_4.5"))
                            Statistic.Iscustvo+=2;
                        else if (answer.equals("@string/answer_4.6"))
                            Statistic.Tourism+=2;
                        else if (answer.equals("@string/answer_4.7"))
                            Statistic.Nastolki+=2;
                        else if (answer.equals("@string/answer_4.8"))
                            Statistic.SportSTech+=2;
                        else if (answer.equals("@string/answer_5.1"))
                            Statistic.EstNauk+=1;
                        else if (answer.equals("@string/answer_5.2"))
                            Statistic.EstNauk+=1;
                        else if (answer.equals("@string/answer_5.3"))
                            Statistic.EstNauk+=1;
                        else if (answer.equals("@string/answer_5.4"))
                            Statistic.jaziki+=2;
                        else if (answer.equals("@string/answer_5.4")) {
                            Statistic.Edinoborstva+=1;
                            Statistic.Horses+=1;
                            Statistic.SportSMachom+=1;
                            Statistic.SilovoySport+=1;
                        }
                        else if (answer.equals("@string/answer_5.5"))
                            Statistic.GumNauki+=1;
                        else if (answer.equals("@string/answer_5.6"))
                            Statistic.GumNauki+=1;
                        else if (answer.equals("@string/answer_5.7"))
                            Statistic.Music+=1;
                        else if (answer.equals("@string/answer_6.1"))
                            Statistic.Nastolki+=1;
                        else if (answer.equals("@string/answer_6.2"))
                            Statistic.Music+=1;
                        else if (answer.equals("@string/answer_6.3"))
                            Statistic.Moda+=2;
                        else if (answer.equals("@string/answer_6.4"))
                            Statistic.Zrelische+=2;
                        else if (answer.equals("@string/answer_6.5"))
                            Statistic.Hareografia+=2;
                        else if (answer.equals("@string/answer_7.1")) {
                            Statistic.Iscustvo += 1;
                            Statistic.Craft+=1;
                        }
                        else if (answer.equals("@string/answer_7.2"))
                            Statistic.Craft+=2;
                        else if (answer.equals("@string/answer_7.3"))
                            Statistic.Journalistic+=2;
                        else if (answer.equals("@string/answer_7.4"))
                            Statistic.Moda+=2;
                        else if (answer.equals("@string/answer_7.5"))
                            Statistic.Iscustvo+=1;
                        else if (answer.equals("@string/answer_7.6"))
                            Statistic.Hareografia+=2;
                        else if (answer.equals("@string/answer_8.1")) {
                            Statistic.Journalistic += 1;
                            Statistic.Music+=1;
                        }
                        else if (answer.equals("@string/answer_8.2"))
                            Statistic.Atletica+=2;
                        else if (answer.equals("@string/answer_8.3"))
                            Statistic.Horses+=2;
                        else if (answer.equals("@string/answer_8.4"))
                            Statistic.Constructor+=2;
                        else if (answer.equals("@string/answer_8.5"))
                            Statistic.jaziki+=2;
                        else if (answer.equals("@string/answer_8.6"))
                            Statistic.Edinoborstva+=2;
                        else if (answer.equals("@string/answer_8.7"))
                            Statistic.Journalistic+=1;
                        else if (answer.equals("@string/answer_8.8"))
                            Statistic.VodniiSport+=1;
                        else if (answer.equals("@string/answer_9.1"))
                            Statistic.ZimniySport+=2;
                        else if (answer.equals("@string/answer_9.2"))
                            Statistic.VodniiSport+=1;
                        else if (answer.equals("@string/answer_9.3"))
                            Statistic.Zrelische+=1;
                        else if (answer.equals("@string/answer_9.4"))
                            Statistic.Moda+=1;
                        else if (answer.equals("@string/answer_9.5"))
                            Statistic.RazvivIGry+=2;
                        else if (answer.equals("@string/answer_10.1"))
                            Statistic.Horses+=2;
                        else if (answer.equals("@string/answer_10.2"))
                            Statistic.Edinoborstva+=2;
                        else if (answer.equals("@string/answer_10.3"))
                            Statistic.Zrelische+=1;
                        else if (answer.equals("@string/answer_10.4"))
                            Statistic.Constructor+=1;
                        else if (answer.equals("@string/answer_10.5"))
                            Statistic.Tourism+=1;

                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SingleAnswer singleAnswer = data.get(position);
        holder.answer.setText(singleAnswer.getQuestion());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<SingleAnswer> getData() {
        return data;
    }

    public void setData(List<SingleAnswer> data) {
        this.data = data;
    }

}