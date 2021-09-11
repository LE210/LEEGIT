package com.example.leelife;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3, edt4, edt5;
    CheckBox chkCO, chkRE, chkEN, chkUN;
    Spinner spinner;
    Button btnStart;
    TextView tv1, tv2, tv3;

    String[] select = {"Appearance(외모)", "Ability(능력)", "personality(성격)", "Lineage(가문)", "Faith(신앙)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("생활 계획");

        edt1 = (EditText) findViewById(R.id.edtNum1);
        edt2 = (EditText) findViewById(R.id.edtNum2);
        edt3 = (EditText) findViewById(R.id.edtNum3);
        edt4 = (EditText) findViewById(R.id.edtNum4);
        edt5 = (EditText) findViewById(R.id.edtNum5);

        chkCO = (CheckBox) findViewById(R.id.chkCODING);
        chkRE = (CheckBox) findViewById(R.id.chkREAD);
        chkEN = (CheckBox) findViewById(R.id.chkENG);
        chkUN = (CheckBox) findViewById(R.id.chkUNDONG);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, select);
        spinner.setAdapter(adapter);

        btnStart = (Button) findViewById(R.id.btnGo);

        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text22);
        tv3 = (TextView) findViewById(R.id.text3);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sleep = edt1.getText().toString();

                if (sleep.equals("")) {
                    final View dia = getLayoutInflater().inflate(R.layout.dialog, null);
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("[Error]")
                            .setMessage("수면시간을 입력해주세요!!")
                            .setView(dia)
                            .show();
                } else {
                    tv1.setText("나는 " + sleep + "시간 잠을 잡니다!");
                }

                Integer Coding = Integer.parseInt(edt2.getText().toString());
                Integer Reading = Integer.parseInt(edt3.getText().toString());
                Integer English = Integer.parseInt(edt4.getText().toString());
                Integer Play = Integer.parseInt(edt5.getText().toString());
                Integer ADD = Coding + Reading + English + Play;

                tv2.setText("나는 꿈을 위해 " + ADD + "시간 투자합니다!");


                tv3.setText("나의 이상형은 " + spinner.getSelectedItem().toString() + "입니다!");

            }
        });
    }
}