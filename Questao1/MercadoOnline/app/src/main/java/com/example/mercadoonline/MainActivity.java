package com.example.mercadoonline;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView total;
    private CheckBox arroz, leite, carne, feijao, coca;
    private double Parroz, Pleite, Pcarne, Pfeijao, Pcoca;
    private double soma = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.total);

        arroz = findViewById(R.id.arroz);
        leite = findViewById(R.id.leite);
        carne = findViewById(R.id.carne);
        feijao = findViewById(R.id.feijao);
        coca = findViewById(R.id.refri);

        Parroz = 2.69;
        Pleite = 2.70;
        Pcarne = 16.70;
        Pfeijao = 3.38;
        Pcoca = 3.00;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculo(View view){
        String txtTotal;
        soma = 0.00;
        if(arroz.isChecked()) soma += Parroz;
        if(leite.isChecked()) soma += Pleite;
        if(carne.isChecked()) soma += Pcarne;
        if(feijao.isChecked()) soma += Pfeijao;
        if(coca.isChecked()) soma += Pcoca;

        DecimalFormat df = new DecimalFormat("#,##0.00");
        txtTotal = df.format(soma);
        total.setText("R$ " + txtTotal);

    }

    public void limpar(View view){
        arroz.setChecked(false);
        leite.setChecked(false);
        carne.setChecked(false);
        feijao.setChecked(false);
        coca.setChecked(false);
        total.setText("R$ 0.00");
    }
}