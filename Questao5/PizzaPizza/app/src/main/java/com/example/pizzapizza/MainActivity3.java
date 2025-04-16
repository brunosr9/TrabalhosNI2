package com.example.pizzapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Button voltar;
    private TextView resumo;
    private String metodo;
    private String totalP;
    private String sabores;
    private String tamanho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        resumo = findViewById(R.id.resumo);
        voltar = findViewById(R.id.voltar);
        Bundle bundle = getIntent().getExtras();
        metodo = bundle.getString("metodo");
        totalP = bundle.getString("total");
        sabores = bundle.getString("sabores");
        tamanho = bundle.getString("tamanho");

        resumo.setText("Você pediu uma pizza tamanho " +tamanho+ " de "+ sabores+ " .Tudo isso deu  R$" +totalP+ " no " +metodo+ ".");

        voltar.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}