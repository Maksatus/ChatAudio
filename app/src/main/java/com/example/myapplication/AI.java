package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AI {
    //Вопрос

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
       //String result = String.join(",",answer);

        String result ="";
        if(answer.size()>1)
        {
            for (int i=0;i<answer.size();i++)
            {
                result = result + answer.get(i);
                result = result + ",";
            }
        return  result.substring(0,result.length()-1);
        }
        else {
            result = answer.get(0);
            return result;
        }

    }
}
