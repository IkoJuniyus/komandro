package com.example.usjul.komandro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup g1;
    EditText tinggi1;
    EditText berat1;
    TextView hasilview,hasilview1;
    Button buttonhasil,reset;
    RadioButton g2,L,P;
    Double ti1,ti2,ti3,be1,ha1;
    String print,print1,print3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1 = (RadioGroup) findViewById(R.id.radioGroupNb);
        tinggi1 = (EditText)findViewById(R.id.kltinggi);
        berat1 = (EditText)findViewById(R.id.klberat);
        hasilview = (TextView)findViewById(R.id.hasilukur);
        hasilview1 = (TextView)findViewById(R.id.hasilukur1);
        buttonhasil = (Button)findViewById(R.id.btnkal);
        reset = (Button)findViewById(R.id.btnreset);
        L = (RadioButton)findViewById(R.id.Lb);
        P = (RadioButton)findViewById(R.id.Pb);
        buttonhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tinggi1.getText().toString().equals("")||berat1.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Tolong isi Semua Kolom",Toast.LENGTH_SHORT).show();
                }else {
                    hitung();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinggi1.setText("");
                berat1.setText("");
                hasilview.setText("");
                hasilview1.setText("");
            }
        });
    }
    public void hitung(){
        int selectedId = g1.getCheckedRadioButtonId();
        g2 = (RadioButton) findViewById(selectedId);
        be1 = Double.parseDouble(berat1.getText().toString());
        ti1 = Double.parseDouble(tinggi1.getText().toString());
        ti2 = ti1/100;//ti2 disini ngubah m jadi cm
        if (g2.getText().equals("laki-laki")){
            print1 = L.getText().toString();
            double p2 = ti1-100;
            print3 = String.valueOf(p2);
        }else {
            print1 = P.getText().toString();
            double p2 = ((ti1-100)*0.9);
            print3 = String.valueOf(p2);
        }
        ti3 = (ti2*ti2);//ti3 disini memiliki value 
        ha1 = be1/ti3;
        if (ha1>=18.5 && ha1<=25){
            print = "Normal";
        }else if (ha1<18.5){
            print = "Kurus";
        }else if (ha1>25){
            print = "Gemuk";
        }
        hasilview.setText(print1+" "+print);
        hasilview1.setText("BBI Standar "+print3);
    }
}
