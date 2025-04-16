package com.example.lanchefacil;

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
    private String lanche;
    private String nome;
    private TextView textoFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        voltar = findViewById(R.id.voltar);
        textoFinal = findViewById(R.id.textoFinal);
        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        lanche = bundle.getString("Lanche");
        textoFinal.setText("Obrigado! "+nome+ "Seu" +lanche+ " ja vai chegar!");

        voltar.setOnClickListener(view ->{
            Intent voltar = new Intent(this, MainActivity.class);
            startActivity(voltar);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}