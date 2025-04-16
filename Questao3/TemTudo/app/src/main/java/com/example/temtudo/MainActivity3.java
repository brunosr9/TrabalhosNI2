package com.example.temtudo;

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
    private TextView seuNome;
    private String Nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        voltar = findViewById(R.id.voltar);

        seuNome = findViewById(R.id.seuNome);
        Nome = seuNome.getText().toString();

        Bundle bundle = getIntent().getExtras();
        Nome = bundle.getString("nome");
        seuNome.setText(Nome);

        voltar.setOnClickListener(view ->{
            Intent voltar = new Intent(this,MainActivity.class);
            startActivity(voltar);
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}