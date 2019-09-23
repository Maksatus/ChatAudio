package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView chatWindow;
    EditText questionText;
    Button sendButton;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //озвучка
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                {
                    tts.setLanguage(new Locale("ru"));
                }
            }
        });

        //инициализация
        chatWindow = findViewById(R.id.chatWindow);
        questionText = findViewById(R.id.questionText);
        sendButton = findViewById(R.id.sendButton);
            //код при нажатии на кнопку
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String question = questionText.getText().toString();
               chatWindow.append(">> "+ question +"\n");

               String answer = AI.getAnswer(question);
               tts.speak(answer,TextToSpeech.QUEUE_ADD,null);
               chatWindow.append(">> "+ answer +"\n");

               questionText.setText("");
            }
        });
    }
}
