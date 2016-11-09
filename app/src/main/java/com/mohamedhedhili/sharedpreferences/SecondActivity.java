package com.mohamedhedhili.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.nfc.tech.NfcBarcode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
TextView text1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SharedPreferences preferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String langue= preferences.getString("langue", "");
        String email = preferences.getString("mail", "");
        text1=(TextView)findViewById(R.id.adresse);
        text1.setText(email);
       setLangRecreate(langue);
    }

    public void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale ;


        if (! "".equals(langval) && ! config.locale.getLanguage().equals(langval)) {
            locale = new Locale(langval);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

}
