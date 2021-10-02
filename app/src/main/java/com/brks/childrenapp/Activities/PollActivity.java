package com.brks.childrenapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.brks.childrenapp.Answers.AnswerAdapter;
import com.brks.childrenapp.R;

import java.util.ArrayList;

public class PollActivity extends AppCompatActivity {

        public int questionglobal = 0;
        private Button btnNext;
        private ListView listView;
        private TextView answerNameText;
        private TextView textAnswers;
        private AnswerAdapter answerAdapter;
        private ArrayList<String> list;
        private String [] questionsbd = {"Тебе интереснее работать в команде или ты расчитываешь только на себя?",
                "В городе построим новый спортивный центр и...",
                "Чем бы ты занялся на каникулах?",
                "Какой подарок попросил бы ты на День Рождения?",
                "Какие предметы в школе тебе нравятся больше всего?",
                "К тебе приходят гости с ночевкой. Чем будете заниматься?",
                "В школе проходит фестиваль мастерклассов. На какой бы ты сходил?",
                "Супер сила:",
                "Вы едете с семьей на курорт:",
                "Какую бы ты выбрал школьную экскурсию?"};

        private String [][] answersbd = {{"Да, работать в команде весело!", "Полагаюсь на себя всегда", "Не могу точно сказать"},
                {"Надеюсь там будет бассейн, обожаю плавать","Супер, наконец будет площадка для футболка","Лучше бы скейт парк построили!","Лишь бы бытовые дорожки построили","Вот бы еще ледяную арену построили для катания на коньках","Жду с нетерпением новый спорт зал!"},
                {"Отправлюсь в путешствие","Наконец в театр схожу","У нас тут выставку открыли","Схожу в зоопарк","Поеду в лагерь","Схожу на концерт любимой группы","Лучше дома посижу и книжку почитаю"},
                {"Конструктор лего","Спортвные костюм","Новые кроссовки","Ролики или коньки","Диск с музыкой","Профессиональные карандаши","Съезжу в поездку","Настольную игру"},
                {"Физика","Математика","Биология","Иностранные языки","Физкультура","Литература","История","Музыека"},
                {"Сыграем в шахматы","Запустим караоке","Устроим показ мод","Сыграем в Крокодила","Дискотека!"},
                {"Выжигание по дереву","Гончарный мастеркласс","Кружок по дебатам","Придумать свой бренд одежды","Открытки","Танцы из фортнайт"},
                {"Иметь чарующий голос","Быть самым быстрым","Уметь общаться с животными","Повелевать роботами","Разговаривать на всех языках","Побеждать в любой драке","Уметь угововрить любого человека"},
                {"Лыжный курорт","На море купаться","Оперный театр","Показ моды в Париже","Тур по"},
                {"Конюшня","Школа боевых искусств","Балет","Музей машиностроения","Спортивное ориентирование"}};

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_poll);



            answerNameText = findViewById(R.id.answerNameText);
            textAnswers = findViewById(R.id.textAnswers);
            btnNext = findViewById(R.id.nextButtonAnswer);
            createQuestion(questionglobal);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createQuestion(questionglobal);

                }
            });
            //answerAdapter = new AnswerAdapter(list);


        }
        public void createQuestion(int question) {
            if (question < 10) {
                answerNameText.setText(questionsbd[question]);
                String answer = "";
                for (int j = 0; j < answersbd[question].length; j++) {
                    answer = answer + answersbd[question][j] +"\n";
                }
                textAnswers.setText(answer);
                questionglobal = questionglobal + 1;
            }
            else{
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
}
