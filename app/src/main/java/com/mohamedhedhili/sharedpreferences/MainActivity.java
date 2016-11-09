package com.mohamedhedhili.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText pass ,mEmailView;
    SharedPreferences sharedpreferences ;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailView = (EditText) findViewById(R.id.email);

        pass = (EditText) findViewById(R.id.password);



        radioGroup = (RadioGroup) findViewById(R.id.radioLangue);


        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(null);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (( mEmailView.getText().toString().equals("medhehili6@gmail.com"))&&(pass.getText().toString().equals("mohamed")))
                {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);

                    sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    if ((radioButton.getText().toString().equals("French")) || (radioButton.getText().toString().equals("Francais"))) {
                        editor.putString("langue", "fr");
                    }
                    if ((radioButton.getText().toString().equals("English")) || (radioButton.getText().toString().equals("Anglais"))) {
                        editor.putString("langue", "en");
                    }

                    Toast.makeText(getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_LONG).show();
                    editor.putString("mail", mEmailView.getText().toString());
                    editor.apply();

                    Intent secondeActivite = new Intent(MainActivity.this, SecondActivity.class);

                    startActivity(secondeActivite);
                }

                else
                    Toast.makeText(getApplicationContext(), "Check  your  login and your password", Toast.LENGTH_LONG).show();






            }
        });

    }

   
}

