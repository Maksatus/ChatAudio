package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class AI {
    //Вопрос
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAnswer (String question)
    {
        ArrayList<String> answer = new ArrayList<>();
        question = question.toLowerCase();


        if (question.contains("привет"))
        {
            answer.add("Здрасте");
        }
        if (question.contains("как")&& question.contains("дела"))
        {
            answer.add("Пошёл в жопу");
        }
        if (question.contains("пока"))
        {
            answer.add("Удачи!");
        }
        if (question.contains("сколько") && question.contains("времени"))
        {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String time = timeFormat.format(new Date());
            answer.add("Точное время:" + time);
        }
        if (question.contains("сегодня") && question.contains("день"))
        {
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd:MM:YYYY");
            String date = dayFormat.format(new Date());
            answer.add("Сегодня:" + date);
        }

        if(answer.size()== 0)
        {
            answer.add("Я тебя не понимаю!");
        }
       String result = String.join(",",answer);

            return result;
    }
}
