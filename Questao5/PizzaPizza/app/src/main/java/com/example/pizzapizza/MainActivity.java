package com.example.pizzapizza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        private CheckBox calabresa;
        private CheckBox marguerita;
        private CheckBox portuguesa;
        private CheckBox frango;
        private int total;
        private Button btnTamanho;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calabresa = findViewById(R.id.calabresa);
        marguerita = findViewById(R.id.marguerita);
        portuguesa = findViewById(R.id.portuguesa);
        frango = findViewById(R.id.frango);
        total = 0;
        btnTamanho = findViewById(R.id.btnTamanho);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void proxTela (View view){
        Intent intent = new Intent(this, MainActivity2.class);
        StringBuilder sabores = new StringBuilder();


        if (!calabresa.isChecked() && !marguerita.isChecked() && !portuguesa.isChecked() && !frango.isChecked()) {
            calabresa.setError("Selecione uma opção");
            marguerita.setError("Selecione uma opção");
            portuguesa.setError("Selecione uma opção");
            frango.setError("Selecione uma opção");

        }
        else {
            if (calabresa.isChecked()) {
                sabores.append("Calabresa, ");
                total += 10;
            }
            if (marguerita.isChecked()) {
                sabores.append("Marguerita, ");
                total += 10;
            }
            if (portuguesa.isChecked()) {
                sabores.append("Portuguesa, ");
                total += 10;
            }
            if (frango.isChecked()) {
                sabores.append("Frango com catupiry, ");
                total += 10;
            }
            if (sabores.length() > 2) {
                sabores.setLength(sabores.length() - 2);
            }

            intent.putExtra("sabores", sabores.toString());
            intent.putExtra("total", String.valueOf(total));
            startActivity(intent);
        }
    }


}