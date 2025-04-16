package com.example.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private Button btnpedir;
    private String Pnome;
    private EditText nome;
    private RadioButton xburger;
    private RadioButton xsalada;
    private RadioButton vegetariano;
    private RadioButton hotdog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main2); // <-- MOVA PRA CÁ

        nome = findViewById(R.id.nome);
        xburger = findViewById(R.id.xburger);
        xsalada = findViewById(R.id.xsalada);
        vegetariano = findViewById(R.id.vegetariano);
        hotdog = findViewById(R.id.hotdog);
        btnpedir = findViewById(R.id.btnpedir);

        btnpedir.setOnClickListener(view -> {
            Intent pedir = new Intent(this, MainActivity3.class);
            Pnome = nome.getText().toString();
            pedir.putExtra("nome", Pnome);
            if(xburger.isChecked()) pedir.putExtra("Lanche", "X-Burger");
            if(xsalada.isChecked()) pedir.putExtra("Lanche", "X-Salada");
            if(vegetariano.isChecked()) pedir.putExtra("Lanche", "Vegetariano");
            if(hotdog.isChecked()) pedir.putExtra("Lanche", "HotDog");
            startActivity(pedir);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}