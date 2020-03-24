package com.example.a07_intent_implicito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearAlarma(View view) {
      Intent intent = new Intent (AlarmClock.ACTION_SET_ALARM)
              .putExtra(AlarmClock.EXTRA_MESSAGE,"Ir al trabajo")
              .putExtra(AlarmClock.EXTRA_HOUR,11)
              .putExtra(AlarmClock.EXTRA_MINUTES,30);
      if(intent.resolveActivity(getPackageManager()) != null){
          startActivity(intent);
      }
    }

    public void llamada(View view) {
        Intent intent = new Intent (Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:112"));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
