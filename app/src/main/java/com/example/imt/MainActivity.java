package com.example.imt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button main_btn;
    TextView logo;
    EditText tall;
    EditText ves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().hide();

        logo = (TextView) findViewById(R.id.logo);
        main_btn = (Button) findViewById(R.id.main_btn);

        tall = (EditText) findViewById(R.id.tall);

        ves = (EditText) findViewById(R.id.ves);


        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tall.getText().toString().trim().equals("") || ves.getText().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите данные", Toast.LENGTH_SHORT);
                    toast.show();

                }else{


                    String value = tall.getText().toString();
                    int finalValueTall = Integer.parseInt(value);
                    String value1 = ves.getText().toString();
                    int finalValueVes = Integer.parseInt(value1);
                    if(finalValueTall>1000 || finalValueVes >1000) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Данные не корректны", Toast.LENGTH_SHORT);
                        toast.show();

                    }else{
                        double imt1 = finalValueTall ^ 2;
                    double imt = finalValueVes / imt1;
                    System.out.println(finalValueVes);
                    System.out.println(finalValueTall);
                    System.out.println(imt);
                    if (imt > 0.42) {
                        logo.setText("У вас ожирение(((");
                    } else if (imt < 0.26) {
                        logo.setText("У вас маленький вес(((");
                    } else {
                        logo.setText("У вас нормальный вес");
                    }}
                }


            }
        });
    }


}