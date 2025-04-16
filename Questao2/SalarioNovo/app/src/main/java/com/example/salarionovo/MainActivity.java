package com.example.salarionovo;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView salario;
    private TextView salarioNovo;
    private RadioButton quarenta, quarentaecinco, cinquenta;
    private double Pquarenta, Pquarentaecinco, Pcinquenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        salario = findViewById(R.id.salario);
        salarioNovo = findViewById(R.id.salarioNovo);

        quarenta = findViewById(R.id.quarenta);
        quarentaecinco = findViewById(R.id.quarentaecinco);
        cinquenta = findViewById(R.id.cinquenta);

        Pquarenta = 1.4;
        Pquarentaecinco = 1.45;
        Pcinquenta = 1.5;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view){
        String SalarioString = salario.getText().toString();
        double Salario = Double.parseDouble(SalarioString);

        if (quarenta.isChecked()){
            Salario *= Pquarenta;
        }
        if (quarentaecinco.isChecked()){
            Salario *= Pquarentaecinco;
        }
        if (cinquenta.isChecked()){
            Salario *= Pcinquenta;
        }
        DecimalFormat df = new DecimalFormat("#,##0.00");
        salarioNovo.setText("R$ " + df.format(Salario));

        }
    }
