package com.example.student1.allsaints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RatingBar;

public class SaintDetail extends AppCompatActivity {

    private WebView mSaintWebView;
    private RatingBar mSaintRating;
    private int mSaintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saint_detail);

        // Находим элементы управления
        mSaintWebView = (WebView) findViewById(R.id.saint_detail);
        mSaintWebView.setWebViewClient(new WebViewClient());
        mSaintRating = (RatingBar) findViewById(R.id.rating);

        // Получаем Intent, с которым была запущена Activity
        Intent intent = getIntent();
        if (intent != null) {
            // Получаем из Intent переданные параметры

            ///
            String saint = intent.getStringExtra(MainActivity.SAINT_NAME);
            ///

            if (saint != null) {
                // Формируем URL для википедии
                saint = saint.replace(" ", "_");
                String url = "https://en.m.wikipedia.org/wiki/" + saint;
                mSaintWebView.loadUrl(url);
            }

            // Вначале проверяем, есть ли такое значение
            if(intent.hasExtra(MainActivity.SAINT_RATING))
            {
                ///
                ///
            }

            if(intent.hasExtra(MainActivity.SAINT_ID))
            {
                ///
                ///
            }
        }
    }

    // По нажатию на кнопку "Back"
    @Override
    public void onBackPressed() {
        // Формируем Intent, который будет возвращен в вызвавшую нас Activity
        ///
        Intent intent = null;

        // Добавляем в Intent нужные параметры
        ///
        ///


        // Устанавливаем результат
        ///
        ///

        // Вызываем onBackPressed суперкласса, закрывая Activity
        super.onBackPressed();
    }
}
